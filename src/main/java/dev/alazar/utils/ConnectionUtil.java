package dev.alazar.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection conn = null;
	public static Connection getConnection() {
	

		if(conn == null) {
		
			try {
				conn = DriverManager.getConnection("jdbc:mariadb://alazar-1.cte6n7x9kggk.us-east-2.rds.amazonaws.com:3306/EmployeeReimbursement?user=admin&password=passw0rd");
		} catch (SQLException e) {
				e.printStackTrace();
			}
				
		}
		return conn;
	}
	public static void main(String[] args) {
		
		Connection conn1 = getConnection();
		System.out.println(conn1);
		
	}
}
