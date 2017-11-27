package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class DbUtil {
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://127.0.0.1:3306/library_mangement_system?"
								+ "useUnicode=true&characterEncoding=utf8&"
								+ "autoReconnect=true&useSSL=false";
	private static String USER = "root";
	private static String PASSWORD = "yjh961024";
	private static Connection conn = null;
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	@Test
	public void test() {
		Connection connection = DbUtil.getConnection();
		if (connection != null)
			System.out.println("haha");
	}
}
