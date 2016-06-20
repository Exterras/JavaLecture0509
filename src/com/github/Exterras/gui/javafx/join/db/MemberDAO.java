package com.github.Exterras.gui.javafx.join.db;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {

	private String vId;
	private String vPwd;
	private String vName;
	private String vEmail;
	private String vPhone;
	private String vAddr;

	private Connection conn = null;
	private Statement stmt = null;
//	private PreparedStatement pstmt = null;

	private int num;

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

		// String insSqlPre = "insert into membert01 values(?,?,?,?,?,?)";

		try {
			conn = dbset.getConnection();
			stmt = conn.createStatement();
			num = stmt.executeUpdate(insSql);

			// pstmt = conn.prepareStatement(insSqlPre);
			// pstmt.setString(1, vId);
			// pstmt.setString(2, vPwd);
			// pstmt.setString(3, vName);
			// pstmt.setString(4, vAddr);
			// pstmt.setString(5, vEmail);
			// pstmt.setString(6, vPhone);
			// num = pstmt.executeUpdate();

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

		DbSet dbset = new DbSet();
		DbClose dbclose = new DbClose();
		String selSql = "select * from membert01" + " where id='" + vId + "' and pwd='" + vPwd + "'";

		ResultSet rs = null;

		try {
			conn = dbset.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selSql);
			// System.out.println(selSql);

			if (rs.next()) {

				// System.out.println(
				// rs.getString("id") + "\t" + rs.getString("name") + "\t" +
				// rs.getString("pwd") + "\t" + rs.getString("addr") + "\t" +
				// rs.getString("email") + "\t" + rs.getString("phone") + "\t");
				String updSql = 
						" update membert01 set name='" + dto.getName() + "', "
						+ "pwd='" + dto.getPwd() + "', addr='" + dto.getAddr()+ "', "
						+ "email='" + dto.getEmail() + "', phone='" + dto.getPhone() 
						+ "' where id='" + rs.getString("id") 
						+ "' and pwd='" + rs.getString("pwd") + "'";
				// System.out.println(updSql);
				int checkSum = stmt.executeUpdate(updSql);
				// System.out.println(
				// vId + "\t" + vName + "\t" + vPwd + "\t" + vAddr + "\t" +
				// vEmail + "\t" + vPhone + "\t");
 
				if (checkSum != 0) {
					System.out.println(vName + "'s Information Update Successfully!");
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

		if (checkId(dto)) {
			DbSet dbset = new DbSet();
			DbClose dbclose = new DbClose();
			ResultSet rs = null;

			try {
				conn = dbset.getConnection();
				stmt = conn.createStatement();

				String delSql = "delete from membert01 where id='" + dto.getId() + "' and pwd='" + dto.getPwd() + "'";
				int checkSum = stmt.executeUpdate(delSql);

				if (checkSum != 0) {
					System.out.println(dto.getName() + "'s Information Delete Successfully!");
					isSuccess = true;
				} else {
					System.out.println("Information Delete Fail!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbclose.close(rs, stmt, conn);
			}

		} 
		return isSuccess;
	}

	public int select(String tableName) {
		DbSet dbset = new DbSet();
		DbClose dbclose = new DbClose();

		String selSql = "select * from " + tableName;

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

	public boolean login(MemberDTO dto) {
		boolean isSuccess = false;

		isSuccess = checkId(dto);

		return isSuccess;
	}

	public boolean checkId(MemberDTO dto) {
		boolean isSuccess = false;
		DbSet dbset = new DbSet();
		DbClose dbclose = new DbClose();

		String selSql = "select * from membert01 where id='" + dto.getId() + "'";
		// System.out.println(selSql);
		ResultSet rs = null;

		try {
			conn = dbset.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selSql);

			if (rs.next()) {

				if (dto.getPwd().equals(rs.getString("pwd"))) {
					System.out.println("Welcome! " + dto.getId());
					isSuccess = true;
				} else {
					System.out.println("Check PWD");
					isSuccess = false;
				}

			} else {
				System.out.println("Check ID");
				isSuccess = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose.close(rs, stmt, conn);
		}

		return isSuccess;
	}
	
	public MemberDTO getMemberData(String id) {
		MemberDTO dto = new MemberDTO();
		DbSet dbset = new DbSet();
		DbClose dbclose = new DbClose();
		String selSql = "select * from membert01 where id = '" + id + "'";

		ResultSet rs = null;

		try {
			conn = dbset.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selSql);

			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddr(rs.getString("addr"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose.close(rs, stmt, conn);
		}

		return dto;
	}
}
