
package com.lin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.lin.utils.ConnectionPool;
import com.lin.utils.User;

public class UserDao{
	private Connection conn = null;

	public User loginUser(String username,String password) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = ConnectionPool.getConnectionPool().getConnection();
		String sql = "SELECT * FROM user WHERE username=? AND password=?";
		User user = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
		rs = ps.executeQuery();
		}catch(SQLException e) {
			System.out.println("数据库连接失败");
		}
		if(rs.next()) {
			user.setNickname(rs.getString("nickname")).setUserID(rs.getInt("userID")).setUsername(rs.getString("username"));
		}
		rs.close();
		ps.close();
		ConnectionPool.getConnectionPool().returnConnection(conn);
		return user;
	}
	
}
