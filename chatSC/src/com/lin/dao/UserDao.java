
package com.lin.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.lin.utils.ConnectionPool;

public class UserDao {
	public int loginUser(String user, String password) {
		Connection conn = ConnectionPool.getConnectionPool().getConnection();
		String sql = "SELECT count(*) FROM user WHERE user=? and password=?";
		Statement st = null;
		
		try {
			st = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
