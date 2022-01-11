package com.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/modelo";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USR = "root";
	private static final String PWD = "novaSenha";
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		try {
			if (connection == null) {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USR, PWD);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection() throws SQLException {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
