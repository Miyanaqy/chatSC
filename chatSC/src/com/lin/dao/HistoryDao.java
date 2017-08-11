package com.lin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lin.utils.ConnectionPool;
import com.lin.utils.Message;

public class HistoryDao {
	public void writeHistory(Message message) {
		PreparedStatement st = null;
		String sql = "insert into history values(null,?,?,?);";
		Connection conn = ConnectionPool.getConnectionPool().getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, message.getUserID());
			st.setString(2, message.getMessage());
			st.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
			int col = st.executeUpdate();
			System.out.println(col);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
