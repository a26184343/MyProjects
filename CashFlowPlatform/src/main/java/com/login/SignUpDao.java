// 508170222 Nick Chen, 508170301 Matt Hsiao
package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUpDao {
	public boolean checkNotDuplicate(String id, String password) {
		// mysql enter section
		String url = "jdbc:mysql://localhost:3306/transfer_platform";
		String sql = "select * from user where iduser=?";
		
		// read data and get result
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, "root", "cj6m/3xu4");
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1,  id);
			System.out.println(sql);
			ResultSet result = pre.executeQuery();
			if(result.next()) {
				System.out.println("duplicate");
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean signUp(String id, String password) {
		// mysql enter section
		String url = "jdbc:mysql://localhost:3306/transfer_platform";
		String sql = "insert into user values (?, ?, 0, 0)";
		
		// read data and get result
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, "root", "cj6m/3xu4");
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1,  id);
			pre.setString(2, password);
			System.out.println(sql);
			int result = pre.executeUpdate();
			if(result == 1) {
				System.out.println("sign up success");
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
