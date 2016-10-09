package cn.mldn.util.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private DatabaseConnection(){}
	private static final String DBDRIVER ="oracle.jdbc.driver.OracleDriver";
	private static final String DBURL ="jdbc:oracle:thin:@localhost:1521:MLDN";
	private static final String DBUSER ="scott";
	private static final String PASSWORD ="tiger";
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	public static Connection rebulidConnection(){
		try {
			Class.forName(DBDRIVER);
			return DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Connection getConnection(){
		Connection conn = threadLocal.get();
		if(conn==null){
			conn = rebulidConnection();
			threadLocal.set(conn);
		}
		return conn;
	}
	public static void close(){
		Connection conn = threadLocal.get();
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			threadLocal.remove();
		}
	}
}
