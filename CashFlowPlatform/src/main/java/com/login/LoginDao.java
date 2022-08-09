// 508170222 Nick Chen, 508170301 Matt Hsiao
package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	public boolean check(String id, String password) {
		// mysql enter section
		String url = "jdbc:mysql://localhost:3306/transfer_platform";
		String sql = "select * from user where iduser=? and passworduser=?";
		
		// read data and get result
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, "root", "cj6m/3xu4");
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1,  id);
			pre.setString(2, password);
			ResultSet result = pre.executeQuery();
			if(result.next()) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String getAccountNumber(String id) {
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
				return Integer.toString(result.getInt("accountNumber"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "";		
	}
}
