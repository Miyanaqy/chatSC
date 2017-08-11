
package com.lin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.lin.utils.ConnectionPool;

public class UserDao {
	
	@Test
	public void loginUser() {
		Connection conn = ConnectionPool.getConnectionPool().getConnection();
		String sql = "SELECT count(*) FROM user WHERE user=? and password=?";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
		st = conn.prepareStatement(sql);
		st.setString(1, "miqnsdf");
		st.setString(2, "sdfnxcvn");
		rs = st.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println(rs);
		
	}
	
}
