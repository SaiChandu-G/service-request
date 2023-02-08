package com.arshaa.request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

	private static String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
	private static String DB_UNAME = "root";
	private static String DB_PASS = "fp@24697";
	private static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
