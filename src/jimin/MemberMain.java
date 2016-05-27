package jimin;

public class MemberMain {

	public static void main(String[] args) {
		MemberDAO oDAO = new MemberDAO();
		MemberDTO oDTO = new MemberDTO( "id001", "���", "1234", "�ϰ�", "id001@test.com", "010-1111-1111" );
		MemberDTO oDTO2 = new MemberDTO( "id001", "1234" );
		
		oDAO.mInsert(oDTO);
//		oDAO.mUpdate(oDTO);
		oDAO.mLogin(oDTO2);
		oDAO.mLogin( "red", "1234" );
	}
}