package memberT01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import memberT01.DbClose;
import memberT01.DbSet;

public class MemberDAO {

	private int num;
	
	public int getNum() {
		return num;
	}

	private String vId, vPwd, vName, vAddr, vEmail, vPhone;
	private Connection conn = null;
	private Statement stmt = null;
	
	void login(MemberDTO dto){
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
			} else {
				System.out.println("Check Id and PWD! ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose.close(rs, stmt, conn);
		}
	}

	void login(String id, String pwd){
		DbSet dbset = new DbSet();
		DbClose dbclose = new DbClose();

		String selSql = "select * from membert01 where id='"+id+"' and pwd='"+pwd+"'";
		
		ResultSet rs = null;
		
		try {
			conn = dbset.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selSql);

			if (rs.next()) {
				System.out.println("Welcome! "+id);
			} else {
				System.out.println("Check Id and PWD! ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose.close(rs, stmt, conn);
		}
	}

	void insert(MemberDTO dto) {
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
			num += stmt.executeUpdate(insSql);

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
	}
	
	void update(MemberDTO dto) {
		vId = dto.getId();
		vPwd = dto.getPwd();
		vName = dto.getName();
		vAddr = dto.getAddr();
		vEmail = dto.getEmail();
		vPhone = dto.getPhone();
		
		DbSet dbset = new DbSet();
		DbClose dbclose = new DbClose();
		String selSql = "select * from membert01"
				+ " where id='"+vId+"'";
		
		ResultSet rs = null;
		
		try {
			conn = dbset.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selSql);
//			System.out.println(selSql);
			
			if (rs.next()) {
				
//				System.out.println(
//						rs.getString("id") + "\t" + rs.getString("name") + "\t" + rs.getString("pwd") + "\t" + rs.getString("addr") + "\t" + rs.getString("email") + "\t" + rs.getString("phone") + "\t");
				String updSql = "update membert01 set name='"+vName+"', pwd='"+vPwd+"', addr='"+vAddr+"', email='"+vEmail+"', phone='" +vPhone+"' where id='"+vId+"'";
//				System.out.println(updSql);
				int checkSum = stmt.executeUpdate(updSql);
//				System.out.println(
//						vId + "\t" + vName + "\t" + vPwd + "\t" + vAddr + "\t" + vEmail + "\t" + vPhone + "\t");
				
				if (checkSum != 0) {
					System.out.println(vName+"'s Information Update Successfully!");
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
	}

	void select(MemberDTO dto) {
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
	}
}
