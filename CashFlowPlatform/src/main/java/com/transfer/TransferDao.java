// 508170222 Nick Chen, 508170301 Matt Hsiao
package com.transfer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransferDao {
	// make sure counterside is valid one
	public boolean checkCounterSideValid(String CounterSide) {
		// mysql enter section
		String url = "jdbc:mysql://localhost:3306/transfer_platform";
		String sql = "select * from user where accountNumber=?";
		
		// read data and get result
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, "root", "cj6m/3xu4");
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1,  CounterSide);
			ResultSet result = pre.executeQuery();
			if(result.next()) {
				System.out.println("counterside valid");
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("counterside invalid");
		return false;
	}
	
	// check the account holder balance is enough
	public boolean balanceIsEnough(String id, String amount) {
		// mysql enter section
		String url = "jdbc:mysql://localhost:3306/transfer_platform";
		String sql = "select * from user where iduser=?";
		
		// read data and get result
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, "root", "cj6m/3xu4");
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1,  id);
			ResultSet result = pre.executeQuery();
			if(result.next()) {
				int t = result.getInt("balanceUser");
				if(t >= Integer.parseInt(amount)) {
					System.out.println("balance enough");
					return true;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("balance not enough");
		return false;
	}
	
	//do transfer
	public void dealTransfer(String account, String counterside,String accountBalance, String countersideBalance, String amount) {
		// mysql enter section
		String url = "jdbc:mysql://localhost:3306/transfer_platform";
		String sql = "insert into details values(?, ?, ?, ?, ?);";//+
				//"insert into details values(0, 0, 0, 0, 0)";
		
		// read data and get result
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, "root", "cj6m/3xu4");
			PreparedStatement pre = connection.prepareStatement(sql);
			// 1. update account holder's details
			pre.setInt(1, Integer.parseInt(account));
			pre.setInt(2, Integer.parseInt(counterside));
			pre.setInt(3, Integer.parseInt(accountBalance) - Integer.parseInt(amount));
			pre.setInt(4, Integer.parseInt(countersideBalance) + Integer.parseInt(amount));
			pre.setInt(5, Integer.parseInt(amount) * -1);
			int result = pre.executeUpdate();
			// 2. update counterside holder's details
			sql = "insert into details values(?, ?, ?, ?, ?);";
			pre = connection.prepareStatement(sql);
			pre.setInt(1, Integer.parseInt(counterside));
			pre.setInt(2, Integer.parseInt(account));
			pre.setInt(3, Integer.parseInt(countersideBalance) + Integer.parseInt(amount));
			pre.setInt(4, Integer.parseInt(accountBalance) - Integer.parseInt(amount));
			pre.setInt(5, Integer.parseInt(amount));
			result = pre.executeUpdate();
			// 3. update account holder's user profile
			sql = "update user set balanceUser = ? where accountNumber = ?";
			pre = connection.prepareStatement(sql);
			pre.setInt(1, Integer.parseInt(accountBalance) - Integer.parseInt(amount));
			pre.setString(2, account);
			result = pre.executeUpdate();
			// 4. update account counterside user profile
			sql = "update user set balanceUser = ? where accountNumber = ?";
			pre = connection.prepareStatement(sql);
			pre.setInt(1, Integer.parseInt(countersideBalance) + Integer.parseInt(amount));
			pre.setString(2, counterside);
			result = pre.executeUpdate();
			if(result == 1) {
				return;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return;
	}
}
