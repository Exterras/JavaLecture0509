package com.github.Exterras.gui.javafx.join.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbClose {
	
	public void close(Statement stmt, Connection conn){
		try {
			stmt.close();
			conn.close();
			System.out.println("DB Close\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(PreparedStatement pstmt, Connection conn){
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void close(ResultSet rs, Statement stmt, Connection conn){
		try {
			rs.close();
			stmt.close();
			conn.close();
			System.out.println("DB Close");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
