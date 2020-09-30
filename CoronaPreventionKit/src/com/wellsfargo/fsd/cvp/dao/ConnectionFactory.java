package com.wellsfargo.fsd.cvp.dao;

import java.sql.Connection;	
import java.sql.SQLException;
import java.sql.DriverManager;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {

	private static DataSource datasource;

	public static Connection getConnection() throws SQLException {

		if (datasource == null) {
			try {
				InitialContext context = new InitialContext();
				datasource = (DataSource) context.lookup("java:/comp/env/jdbc/MyDB");
			} catch (NamingException e) {
				e.printStackTrace();
			}

		}
		return datasource.getConnection();
	}
}
