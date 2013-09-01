package org.springperu.curso.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static String url = "jdbc:postgresql://localhost:5432/dbspring";
	private static String password = "postgres";
	private static String user = "postgres";
	public static Connection getConnection(){
		Connection conn= null;
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				conn =  DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("No se pudo conectar a la base de datos");
			}
		return conn;
	}
}
