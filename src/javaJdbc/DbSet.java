package javaJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSet {

	static Statement stmt;
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String uid = "hr";
	private static String upw = "happyday";

	static void getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, uid, upw);
			System.out.println("Driver Interlock Success");

			stmt = conn.createStatement();
			System.out.println("DB Interlock Success"+"\n");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
