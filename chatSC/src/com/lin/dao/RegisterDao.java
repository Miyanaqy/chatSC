package com.lin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lin.utils.ConnectionPool;

public class RegisterDao {
	private Connection conn = null;
	
	public boolean queryUsername(String username) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = ConnectionPool.getConnectionPool().getConnection();
		String sql = "SELECT * FROM user WHERE username=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		boolean b = rs.next();
		rs.close();
		ps.close();
		ConnectionPool.getConnectionPool().returnConnection(conn);
		return b;
	}
	
	public boolean queryNickname(String nickname) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = ConnectionPool.getConnectionPool().getConnection();
		String sql = "SELECT * FROM user WHERE nickname=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, nickname);
		rs = ps.executeQuery();
		boolean b = rs.next();
		rs.close();
		ps.close();
		ConnectionPool.getConnectionPool().returnConnection(conn);
		return b;
	}
	
	public int insertUser(String username, String password, String nickname) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = ConnectionPool.getConnectionPool().getConnection();
		String sql = "INSERT INTO user VALUES(null,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, nickname);
		int i = ps.executeUpdate();
		ps.close();
		ConnectionPool.getConnectionPool().returnConnection(conn);
		return i;
	}
}
