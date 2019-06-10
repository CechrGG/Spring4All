/**
 * @Title: JDBCTest.java
 * @Package: review.database
 * @Description: TODO
 *
 */
package review.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Leslie
 * @version 创建时间：2019年6月10日
 *
 */
public class JDBCTest {
	
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String MYSQL_URL = "jdbc:mysql://192.168.76.100:3306/openisa";
	private static final String USER_NAME = "openisa";
	private static final String PASSWORD = "OpenISA@123";
	
	private static Connection conn = null;
	

	/**
	 * @return the conn
	 */
	public static Connection getConn() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(MYSQL_URL, USER_NAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConn() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	/**
	 * @author: Leslie
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTest.getConn();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM t_user";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("user_id") + rs.getString("user_name") + rs.getString("email"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				JDBCTest.closeConn();
			}
		}
	}

}
