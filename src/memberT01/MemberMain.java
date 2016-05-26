package memberT01;

public class MemberMain {
	
	MemberDAO dao = new MemberDAO();
	
	public void showInsert(String id, String name, String pwd, String addr, String email, String phone){
		MemberDTO insDTO = new MemberDTO(id,pwd,name,addr,email,phone); 
		dao.insert(insDTO);
	}
	
	public void showUpdate(String id, String name, String pwd, String addr, String email, String phone){
		MemberDTO updDTO = new MemberDTO(id,pwd,name,addr,email,phone); 
		dao.update(updDTO);
	}
	
	public void showSelect(){
		MemberDTO selDTO = new MemberDTO(); 
		dao.select(selDTO);
	}
	
	public void showLogin(MemberDTO dto){
		dao.login(dto);
	}
	
	public void showLogin(String id, String pwd){
		dao.login(id, pwd);
	}
	
	public static void main(String[] args) {
		MemberMain memberT01 = new MemberMain();
		MemberDTO logDTO = new MemberDTO("Three", "1547"); 
		
//		memberT01.showInsert("Three", "Ronaldo", "1547", "Madrid", "Ronaldo@test.com", "123-1234");
//		memberT01.showInsert("Four", "Messi", "9487", "Barcelona", "Messi@test.com", "145-3254");
//		memberT01.showInsert("Five", "Park", "6652", "Seoul", "Park@test.com", "654-9852");
//		System.out.println("Total Join Success Number : " + main.dao.getNum());
		
//		memberT01.showUpdate("Three", "Ronaldu", "1547", "Madrid", "Ronaldu@test.com", "123-1234");
		// first string value(id) is primary key, not changed, unique of record.
		
		memberT01.showLogin(logDTO);
		
		memberT01.showLogin("Three", "1547");

	}
	
}
