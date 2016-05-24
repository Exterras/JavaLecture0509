package javaJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class memSelect {
	
	private static String vId, vPwd, vName, vAddr, vEmail, vPhone;
	
	public static void main(String[] args) {
			
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "hr";
		String upw = "happyday";
		
		String selSql = "select * from membert01";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Interlock Success");
			
			Connection conn = DriverManager.getConnection(url, uid, upw);
			System.out.println("DB Interlock Success\n");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selSql);
			
			System.out.println("ID\tPWD\tNAME\tADDR\tEMAIL\t\tPHONE\t");
					
			while (rs.next()) {
				vId = rs.getString(1);
				vPwd = rs.getString(2);
				vName = rs.getString(3);
				vAddr = rs.getString(4);
				vEmail = rs.getString(5);
				vPhone = rs.getString(6);
				
//				vId = rs.getString("id");
//				vPwd = rs.getString("pwd");
//				vName = rs.getString("name");
//				vAddr = rs.getString("addr");
//				vEmail = rs.getString("email");
//				vPhone = rs.getString("phone");
				
//				System.out.println(
//						"ID : "+vId+"\n"+
//						"PWD : "+vPwd+"\n"+
//						"NAME : "+vName+"\n"+
//						"ADDR : "+vAddr+"\n"+
//						"EMAIL : "+vEmail+"\n"+
//						"PHONE : "+vPhone+"\n");
			
				System.out.println(vId+"\t"+vPwd+"\t"+vName+"\t"+vAddr+"\t"+vEmail+"\t"+vPhone+"\t");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
