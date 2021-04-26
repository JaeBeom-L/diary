package gdu.diary.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/diary", "root", "java1004");
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		// fianlly 절을 구현하여 conn.close()를 하면 안되는 이유?
		// conn return해야하기떄문
		return conn;
	}
}
