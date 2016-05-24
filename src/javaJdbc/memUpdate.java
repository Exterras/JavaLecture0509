package javaJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class memUpdate {
	public static void main(String[] args) {
			
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "hr";
		String upw = "happyday";
		String updSql = "UPDATE MEMBERT01 SET NAME = 'Rose', PHONE = '010-1234-5678' WHERE (ID = 'red')";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Interlock Success");
			
			Connection conn = DriverManager.getConnection(url, uid, upw);
			System.out.println("DB Interlock Success");
			
			Statement stmt = conn.createStatement();
			int num = stmt.executeUpdate(updSql);
			System.out.println(num + " Members Update Success");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
