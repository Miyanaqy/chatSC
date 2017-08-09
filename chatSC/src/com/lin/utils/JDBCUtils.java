package com.lin.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private static final String DRIVER;
	private static final String URL;
	private static final String USER;
	private static final String PASSWORD;
	
	static {
		Properties pro = new Properties();
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream("jdbc.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DRIVER = pro.getProperty("driver");
		URL = pro.getProperty("url");
		USER = pro.getProperty("user");
		PASSWORD = pro.getProperty("password");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}
	public static void closeData(Connection conn, Statement st, ResultSet rs) {
		
	}
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeStatement(Statement st) {
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeResultSet(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
