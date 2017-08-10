package com.lin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.lin.utils.ConnectionPool;
import com.lin.utils.Message;

public class HistoryDao {
	private static int num = 0;
	public void writeHistory(Message message) {
		PreparedStatement st = null;
		String sql = "insert into history values(?,?,?,?);";
		Connection conn = ConnectionPool.getConnectionPool().getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, num++);
			st.setInt(2, message.getUserID());
			st.setString(3, message.getMessage());
			st.setDate(4, new Date(System.currentTimeMillis()));
			int col = st.executeUpdate();
			System.out.println(col);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}