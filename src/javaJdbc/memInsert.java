package javaJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class memInsert {
	public static void main(String[] args) {
			
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "hr";
		String upw = "happyday";
		String insSql = "insert into membert01 values('pink','sparta','4321','busan','pink@pink.com','051-245-6987')";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Interlock Success");
			
			Connection conn = DriverManager.getConnection(url, uid, upw);
			System.out.println("DB Interlock Success");
			
			Statement stmt = conn.createStatement();
			int num = stmt.executeUpdate(insSql);
			System.out.println(num + " Members Join Success");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
