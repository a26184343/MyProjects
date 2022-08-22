// 508170222 Nick Chen, 508170301 Matt Hsiao
package com.upload;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProfileDao {
	public String getBalance(String accountNumber) {
		// mysql enter section
		String url = "jdbc:mysql://localhost:3306/transfer_platform";
		String sql = "select * from user where accountNumber=?";
		
		// read data and get result
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, "root", "cj6m/3xu4");
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1,  accountNumber);
			ResultSet result = pre.executeQuery();
			if(result.next()) {
				return Integer.toString(result.getInt("balanceUser"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String [] getDetails(String accountNumber) {
		String [] details = new String [10];
		// mysql enter section
		String url = "jdbc:mysql://localhost:3306/transfer_platform";
		String sql = "select * from details where accountNumber=?";
				
		// read data and get result
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, "root", "cj6m/3xu4");
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1,  accountNumber);
			ResultSet result = pre.executeQuery();
			int i = 0;
			while(result.next()) {
				details[++i - 1] = "Counter side: " + result.getString("counterside") + "\t, Amount" + result.getString("amount") + "\t, Present balance" + result.getString("accountBalance");
				if(i == 9)
					i = 0;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return details;
	}
	
}
