package jimin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {
	String vId;
	String vName;
	String vPwd;
	String vAddr;
	String vEmail;
	String vPhone;
	
	String 		sql 	= null;
	int 			num  = 0;
	Connection conn	= null;
	Statement 	stmt	= null;
	ResultSet		rs		= null;
	
	/*******************************************************************
					void mInsert(MemberDTO oDTO)		
	*******************************************************************/
	int mInsert(MemberDTO oDTO) {
		vId 		=	oDTO.getId();
		vName 	=	oDTO.getName();
		vPwd 		=	oDTO.getPwd();
		vAddr 	=	oDTO.getAddr();
		vEmail 	=	oDTO.getEmail();
		vPhone 	=	oDTO.getPhone();

//		sql = "insert into memberT01 values('" + vId + "','" + vName + "','" + vPwd + "','" + vAddr + "','" + vEmail + "','" + vPhone + "')";
		sql = "delete from memberT01 where id='123'";

		try {
			conn = DbSet.getConnection();
			stmt = conn.createStatement();			
			num = stmt.executeUpdate(sql);
			
			if( num != 0 ){
				System.out.println( vName + "�� ȸ������ ����!!");	
			} else {
				System.out.println( vName + "�� ȸ������ ����!!");	
			}			
			System.out.println();		
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DbClose.close(stmt, conn);
		}		
		return num;
	}
	
	/*******************************************************************
				void mUpdate(MemberDTO oDTO)		
	*******************************************************************/
	void mUpdate(MemberDTO oDTO) {
		vId 		=	oDTO.getId();
		vName 	=	oDTO.getName();
		vPwd 		=	oDTO.getPwd();
		vAddr 	=	oDTO.getAddr();
//		vAddr 	=	"���";
		vEmail 	=	oDTO.getEmail();
		vPhone 	=	oDTO.getPhone();

		sql = "select * from memberT01 where id ='" + vId + "' and pwd ='" +  vPwd + "'";
				
		try{
			conn	= DbSet.getConnection();
			stmt	= conn.createStatement();					
			rs = stmt.executeQuery(sql);			
			
			if(rs.next()) {
				sql = "update memberT01 set addr='" + vAddr + "' where id ='" + vId + "' and pwd ='" +  vPwd + "'";
				num 	= stmt.executeUpdate(sql);		
				
				if( num != 0 ){
					System.out.println(vName + "�� ȸ������ ���� ����");
				} else {
					System.out.println(vName + "�� ȸ������ ���� ����");
				}
			} else {
				System.out.println("ID or PASSWORD Ȯ���ʿ�");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.close(rs, stmt, conn);
		}
	}
	
	/*******************************************************************
				void mLogin(MemberDTO oDTO)		
	*******************************************************************/
	void mLogin(MemberDTO oDTO) {
		vId 		=	oDTO.getId();
//		vName 	=	oDTO.getName();
		vPwd 		=	oDTO.getPwd();
//		vAddr 	=	oDTO.getAddr();
//		vEmail 	=	oDTO.getEmail();
//		vPhone 	=	oDTO.getPhone();

		sql = "select * from memberT01 where id='" + vId + "' and pwd='" + vPwd + "'";
		
		try {
			conn 	=	DbSet.getConnection();
			stmt 	=	conn.createStatement();
			rs		=	stmt.executeQuery(sql);
			
			if(rs.next()) {				
				System.out.println(vId + "�� �α��� Ȯ��");
			} else {
				System.out.println("ID or PASSWORD Ȯ���ʿ�");
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DbClose.close(rs, stmt, conn);
		}	
	}
	
	/*******************************************************************
				void mLogin(String id, String pwd)
	*******************************************************************/
	void mLogin(String id, String pwd) {
		sql = "select * from memberT01 where id='" + id + "' and pwd='" + pwd + "'";
		
		try {
			conn 	=	DbSet.getConnection();
			stmt 	=	conn.createStatement();
			rs		=	stmt.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println(id + "�� �α��� Ȯ��");
			} else {
				System.out.println("ID or PASSWORD Ȯ���ʿ�");
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DbClose.close(rs, stmt, conn);
		}	
	}
}