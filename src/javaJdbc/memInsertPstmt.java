package javaJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import memberT01.DbClose;
import memberT01.DbSet;

public class memInsertPstmt {
	
	public int insert() {
		
		DbSet dbset = new DbSet();
		DbClose dbclose = new DbClose();
		String name = "Twitch";
		int num = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String insSqlPre = "insert into membert01 values(?,?,?,?,?,?)";

		try {
			conn = dbset.getConnection();
			pstmt = conn.prepareStatement(insSqlPre);
			
			pstmt.setString(1, "green");
			pstmt.setString(2, name);
			pstmt.setString(3, "1234");
			pstmt.setString(4, "Sangam");
			pstmt.setString(5, "green@test.com");
			pstmt.setString(6, "O2");
			
			num = pstmt.executeUpdate();

			if (num != 0) {
				System.out.println("Welcome! " + name);
			} else {
				System.out.println("Join Fail");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose.close(pstmt, conn);
		}
		
		return num;
	}
}
