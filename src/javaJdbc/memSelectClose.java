package javaJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class memSelectClose {
	
	private String vId, vPwd, vName, vAddr, vEmail, vPhone;
	
	public void select(){
		DbSet dbset = new DbSet();	
		DbClose dbclose = new DbClose();
		
		String selSql = "select * from membert01";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbset.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selSql);
			
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
			
				System.out.println(vId+"\t"+vName+"\t"+vPwd+"\t"+vAddr+"\t"+vEmail+"\t"+vPhone+"\t");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose.close(rs, stmt, conn);
		}
	}
	
	public static void main(String[] args) {
		memSelectClose objSel = new memSelectClose();
		objSel.select();
	}
}
