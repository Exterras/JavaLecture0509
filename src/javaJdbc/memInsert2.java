package javaJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class memInsert2 {
	
	void insert(String vId, String vPwd, String vName, String vAddr, String vEmail, String vPhone){
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "hr";
		String upw = "happyday";
		String insSql = "insert into membert01 values('"+vId+"','"+vName+"','"+vPwd+"','"+vAddr+"','"+vEmail+"','"+vPhone+"')";
		
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
	
	public static void main(String[] args) {
		memInsert2 objIns = new memInsert2();
		objIns.insert("purple", "1579", "bora", "Dobong", "purple@pp.com", "02-6547-6547");
	}
}
