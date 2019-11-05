package com.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConnection() throws Exception {
		Connection con = null;
		// DB 접속정보
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/mysqldb");
		con = ds.getConnection();
		
		return con;
	}
	
	// SELECT문을 수행한 후 리소스 해제를 위한 메소드
		public static void close(Connection con, Statement stmt, ResultSet rs) {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // close method

		// INSERT, UPDATE, DELETE문을 수행한 후 리소스 해제를 위한 메소드
		public static void close(Connection con, Statement stmt) {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} // close method
}
