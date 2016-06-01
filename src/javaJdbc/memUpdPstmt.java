package javaJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import memberT01.DbClose;
import memberT01.DbSet;

public class memUpdPstmt {
	
public int update() {
		
		DbSet dbset = new DbSet();
		DbClose dbclose = new DbClose();
		String name = "Twitch";
		int num = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String updSqlPre = "update membert01 "
				+ "set name=?, pwd=?, addr=?, email=?, phone=?"
				+ "where id=? and pwd=?";

		try {
			conn = dbset.getConnection();
			pstmt = conn.prepareStatement(updSqlPre);
			
			pstmt.setString(1, name);
			pstmt.setString(2, "1234");
			pstmt.setString(3, "Sangam");
			pstmt.setString(4, "green@test.com");
			pstmt.setString(5, "O2");
			pstmt.setString(6, "green");
			pstmt.setString(7, "1234");
			
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
