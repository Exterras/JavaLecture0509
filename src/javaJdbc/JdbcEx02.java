package javaJdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcEx02 {
	public static void main(String[] args) {
			
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "hr";
		String upw = "happyday";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Interlock Success");
			
			DriverManager.getConnection(url, uid, upw);
			System.out.println("DB Interlock Success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
