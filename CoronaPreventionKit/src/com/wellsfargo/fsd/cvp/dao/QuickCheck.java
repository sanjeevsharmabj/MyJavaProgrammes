package com.wellsfargo.fsd.cvp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QuickCheck {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/covidprds", "root", "root");
				System.out.println("connection opened");
				return con;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
