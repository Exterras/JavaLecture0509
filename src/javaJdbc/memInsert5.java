package javaJdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class memInsert5 {

	private static String[] id = { "id001", "id002", "id003", "id004" };
	private static String[] pwd = { "1234", "3214", "5678", "2345" };
	private static String[] name = { "Rupi", "Zoro", "Chopa", "Robin" };
	private static String[] addr = { "Seoul", "Daejeon", "Daegu", "Busan" };
	private static String[] email = { "id001@email.com", "id002@email.com", "id003@email.com", "id004@email.com" };
	private static String[] phone = { "010-8452-9741", "010-9632-2587", "010-8754-6598", "010-1235-5487" };

	private static int i;
	private int num;
	
	public void insert(String vId, String vPwd, String vName, String vAddr, String vEmail, String vPhone) {
		
		DbSet dbset = new DbSet();
		DbClose dbclose = new DbClose();
		String insSql = "insert into membert01 values('" + vId + "','" + vName + "','" + vPwd + "','" + vAddr + "','"
				+ vEmail + "','" + vPhone + "')";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {	
			conn = dbset.getConnection();
			stmt = conn.createStatement();
			num += stmt.executeUpdate(insSql);
			
			if (num != 0) {
				System.out.println("Welcome! " + name[i] + "\n");
			} else {
				System.out.println("Join Fail" + "\n");
			}

			if (i == id.length - 1) {
				System.out.println("Total Join Success Number : " + num);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose.close(stmt, conn);
		}
	}

	public static void main(String[] args) {
		memInsert5 objIns = new memInsert5();
		for (i = 0; i < id.length; i++) {
			objIns.insert(id[i], pwd[i], name[i], addr[i], email[i], phone[i]);
		}
	}
}
