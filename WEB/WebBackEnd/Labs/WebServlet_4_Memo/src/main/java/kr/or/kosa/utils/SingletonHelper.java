package kr.or.kosa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class SingletonHelper {
	private static Connection conn = null; //public > private
	private SingletonHelper() {}

	public static Connection getConnection(String dsn) {
		if(conn != null) {
			//System.out.println("conn is not null");
			return conn;
		}
		try {
			  if(dsn.equals("oracle")) {
				  Class.forName("oracle.jdbc.OracleDriver");
				  conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","KOSA","1004");
			  }else if(dsn.equals("mysql")) {
				  Class.forName("com.mysql.cj.jdbc.Driver");
				  conn = DriverManager.getConnection("jdbc:mysql://192.168.0.3:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true","kosta","1004");
			  }

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		//System.out.println("conn return");
		return conn; 
	}

	

	public static void dbClose() {
		if(conn != null) {
			try {
				 conn.close();
				 conn = null; 
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

     public static void close(Connection conn) {

		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	
	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
