package com.lin.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {
	private static ConnectionPool connectionPool = null;
	private Vector<Connection> pool;
	private ConnectionPool() {
		pool = new Vector<Connection>();
		try {
			createConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static ConnectionPool getConnectionPool() {
		if(ConnectionPool.connectionPool == null) {
			ConnectionPool.connectionPool = new ConnectionPool();
		}
		return ConnectionPool.connectionPool;
	}
	public void createConnection() throws SQLException {
		for(int i = 0; i < 5; i++) {
			Connection conn = JDBCUtils.getConnection();
			this.pool.add(conn);
		}
	}
	public Connection getConnection() {
		Connection conn = null;
		if(pool.isEmpty()) {
			try {
				createConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			conn = this.pool.remove(0);
		}
		return conn;
	}
	public void returnConnection(Connection conn) {
		this.pool.add(conn);
	}
}
