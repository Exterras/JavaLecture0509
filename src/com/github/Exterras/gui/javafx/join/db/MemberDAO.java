package com.github.Exterras.gui.javafx.join.db;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import memberT01.DbClose;
import memberT01.DbSet;

public class MemberDAO implements Initializable{
	
	private String vId;
	private String vPwd;
	private String vName;
	private String vEmail;
	private String vPhone;
	private String vAddr;
	
	private Connection conn = null;
	private Statement stmt = null;
	
	private int num;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public boolean login(MemberDTO dto){
		boolean isSuccess = false;
		DbSet dbset = new DbSet();
		DbClose dbclose = new DbClose();

		String selSql = "select * from membert01 where id='"+dto.getId()+"' and pwd='"+dto.getPwd()+"'";
		
		ResultSet rs = null;
		
		try {
			conn = dbset.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selSql);

			if (rs.next()) {
				System.out.println("Welcome! "+dto.getId());
				isSuccess = true;
			} else {
				System.out.println("Check ID and PWD! ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose.close(rs, stmt, conn);
		}
		
		return isSuccess;
	}

	public int insert(MemberDTO dto) {
		DbSet dbset = new DbSet();
		DbClose dbclose = new DbClose();

		vId = dto.getId();
		vPwd = dto.getPwd();
		vName = dto.getName();
		vAddr = dto.getAddr();
		vEmail = dto.getEmail();
		vPhone = dto.getPhone();

		String insSql = "insert into membert01 values('" + vId + "','" + vName + "','" + vPwd + "','" + vAddr + "','"
				+ vEmail + "','" + vPhone + "')";

		try {
			conn = dbset.getConnection();
			stmt = conn.createStatement();
			num = stmt.executeUpdate(insSql);

			if (num != 0) {
				System.out.println("Welcome! " + vName);
			} else {
				System.out.println("Join Fail");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose.close(stmt, conn);
		}
		
		return num;
	}
	
	public boolean update(MemberDTO dto) {
		boolean isSuccess = false;
		
		vId = dto.getId();
		vPwd = dto.getPwd();
		vName = dto.getName();
		vAddr = dto.getAddr();
		vEmail = dto.getEmail();
		vPhone = dto.getPhone();
		
		DbSet dbset = new DbSet();
		DbClose dbclose = new DbClose();
		String selSql = "select * from membert01"
				+ " where id='"+vId+"' and pwd='"+vPwd+"'";
		
		ResultSet rs = null;
		
		try {
			conn = dbset.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selSql);
//			System.out.println(selSql);
		
			if (rs.next()) {
				
				String preId = rs.getString("id");
				String prePwd = rs.getString("pwd");
				
//				System.out.println(
//						rs.getString("id") + "\t" + rs.getString("name") + "\t" + rs.getString("pwd") + "\t" + rs.getString("addr") + "\t" + rs.getString("email") + "\t" + rs.getString("phone") + "\t");
				String updSql = "update membert01 set name='"+vName+"', pwd='"+vPwd+"', addr='"+vAddr+"', email='"+vEmail+"', phone='" +vPhone+"' where id='"+preId+"' and pwd='"+prePwd+"'";
//				System.out.println(updSql);
				int checkSum = stmt.executeUpdate(updSql);
//				System.out.println(
//						vId + "\t" + vName + "\t" + vPwd + "\t" + vAddr + "\t" + vEmail + "\t" + vPhone + "\t");
				
				if (checkSum != 0) {
					System.out.println(vName+"'s Information Update Successfully!");
					isSuccess = true;
				} else {
					System.out.println("Information Update Fail!");
				}
				
			} else {
				System.out.println("Check ID or PWD");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose.close(rs, stmt, conn);
		}
		
		return isSuccess;
	}
	
	public boolean delete(MemberDTO dto) {
		boolean isSuccess = false;
		
		vId = dto.getId();
		vPwd = dto.getPwd();
		vName = dto.getName();
		vAddr = dto.getAddr();
		vEmail = dto.getEmail();
		vPhone = dto.getPhone();
		
		DbSet dbset = new DbSet();
		DbClose dbclose = new DbClose();
		String selSql = "select * from membert01"
				+ " where id='"+vId+"' and pwd='"+vPwd+"'";
		
		ResultSet rs = null;
		
		try {
			conn = dbset.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selSql);
//			System.out.println(selSql);
		
			if (rs.next()) {
				String preName = rs.getString("name");
//				System.out.println(
//						rs.getString("id") + "\t" + rs.getString("name") + "\t" + rs.getString("pwd") + "\t" + rs.getString("addr") + "\t" + rs.getString("email") + "\t" + rs.getString("phone") + "\t");
				String delSql = "delete from membert01 where id='"+vId+"' and pwd='"+vPwd+"'";
//				System.out.println(updSql);
				int checkSum = stmt.executeUpdate(delSql);
//				System.out.println(
//						vId + "\t" + vName + "\t" + vPwd + "\t" + vAddr + "\t" + vEmail + "\t" + vPhone + "\t");
				
				if (checkSum != 0) {
					System.out.println(preName+"'s Information Delete Successfully!");
					isSuccess = true;
				} else {
					System.out.println("Information Delete Fail!");
				}
				
			} else {
				System.out.println("Check ID or PWD");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose.close(rs, stmt, conn);
		}
		
		return isSuccess;
	}

	public int select(MemberDTO dto) {
		DbSet dbset = new DbSet();
		DbClose dbclose = new DbClose();

		String selSql = "select * from membert01";
		
		ResultSet rs = null;
		
		try {
			conn = dbset.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selSql);

			System.out.println("ID\tPWD\tNAME\tADDR\tEMAIL\t\tPHONE\t");

			while (rs.next()) {

				vId = rs.getString("id");
				vPwd = rs.getString("pwd");
				vName = rs.getString("name");
				vAddr = rs.getString("addr");
				vEmail = rs.getString("email");
				vPhone = rs.getString("phone");

				System.out.println(
						vId + "\t" + vName + "\t" + vPwd + "\t" + vAddr + "\t" + vEmail + "\t" + vPhone + "\t");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose.close(rs, stmt, conn);
		}
		
		return num;
	}

	
}
