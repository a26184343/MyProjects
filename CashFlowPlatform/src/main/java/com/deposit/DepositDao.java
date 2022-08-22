// 508170222 Nick Chen, 508170301 Matt Hsiao
package com.deposit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DepositDao {
	public void deposit(String accountNumber, String depositAmount) {
		// mysql enter section
		String url = "jdbc:mysql://localhost:3306/transfer_platform";
		String sql = "select * from user where accountNumber = ?";
		
		// read data and get result
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, "root", "cj6m/3xu4");
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setInt(1,  Integer.parseInt(accountNumber));
			ResultSet result = pre.executeQuery();
			int presentBalance = 0;
			if(result.next()) {
				presentBalance = result.getInt("balanceUser");
			}
			sql = "update user set balanceUser = ? where accountNumber = ?";
			pre = connection.prepareStatement(sql);
			pre.setInt(1,  presentBalance + Integer.parseInt(depositAmount));
			pre.setInt(2, Integer.parseInt(accountNumber));
			int r = pre.executeUpdate();
			if(r == 1)
				return;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
