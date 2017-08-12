
package com.lin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.lin.utils.ConnectionPool;
import com.lin.utils.User;

public class UserDao{
	
	@Test
	public User loginUser(String username,String password) throws SQLException {
		Connection conn = ConnectionPool.getConnectionPool().getConnection();
		String sql = "SELECT * FROM user WHERE username=? and password=?";
		PreparedStatement st = null;
		ResultSet rs = null;
		User user = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
		rs = st.executeQuery();
		}catch(SQLException e) {
			System.out.println("数据库连接失败");
		}
		if(rs.next()) {
			user.setNickname(rs.getString("nickname"));
			user.setUserID(rs.getInt("userID"));
			user.setUsername(rs.getString("username"));
		}
		return user;
	}
	
}
