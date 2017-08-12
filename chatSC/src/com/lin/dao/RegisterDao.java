package com.lin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lin.utils.ConnectionPool;

public class RegisterDao {
	private Connection conn = null;
	
	public boolean queryUsername() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = ConnectionPool.getConnectionPool().getConnection();
		String sql = "SELECT * FROM user WHERE username=?";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		boolean b = rs.next();
		rs.close();
		ps.close();
		ConnectionPool.getConnectionPool().returnConnection(conn);
		return b;
	}
	
	public boolean queryNickname() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = ConnectionPool.getConnectionPool().getConnection();
		String sql = "SELECT * FROM user WHERE nickname=?";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		boolean b = rs.next();
		rs.close();
		ps.close();
		ConnectionPool.getConnectionPool().returnConnection(conn);
		return b;
	}
	
	public int insertUser() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = ConnectionPool.getConnectionPool().getConnection();
		String sql = "INSERT INTO user VALUES(null,?,?,?)";
		ps = conn.prepareStatement(sql);
		int i = ps.executeUpdate();
		ps.close();
		ConnectionPool.getConnectionPool().returnConnection(conn);
		return i;
	}
}
