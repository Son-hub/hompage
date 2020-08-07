package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import db.DBclass;
import db.DBconfig;

public class DBclass {
	public static Connection condb() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/dbdb";
		Connection conn = DriverManager.getConnection(DBconfig.DB_URL, DBconfig.DB_USER, DBconfig.DB_PW);
		System.out.println("연결 성공");
		return conn;
	}

	public static void connTest() {
		Connection conn = null;

		try {
			conn = DBclass.condb();
		}
			catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}