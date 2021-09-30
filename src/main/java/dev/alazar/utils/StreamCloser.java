package dev.alazar.utils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StreamCloser {

	public static void close(ResultSet resource) {
		if(resource != null) {
			try {
				resource.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement resource) {
		if(resource != null) {
			try {
				resource.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection resource) {
		if(resource != null) {
			try {
				resource.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}