package memberT01;

public class MemberMain {
	
	MemberDAO dao = new MemberDAO();
	
	public void mainInsert(String id, String name, String pwd, String addr, String email, String phone){
		MemberDTO insDTO = new MemberDTO(id,pwd,name,addr,email,phone); 
		dao.insert(insDTO);
	}
	
	public void mainUpdate(String id, String name, String pwd, String addr, String email, String phone){
		MemberDTO updDTO = new MemberDTO(id,pwd,name,addr,email,phone); 
		dao.update(updDTO);
	}
	
	public void mainSelect(){
		MemberDTO selDTO = new MemberDTO(); 
		dao.select(selDTO);
	}
	
	public static void main(String[] args) {
		MemberMain memberT01 = new MemberMain();
		
//		main.mainInsert("Three", "Ronaldo", "1547", "Madrid", "Ronaldo@test.com", "123-1234");
//		main.mainInsert("Four", "Messi", "9487", "Barcelona", "Messi@test.com", "145-3254");
//		main.mainInsert("Five", "Park", "6652", "Seoul", "Park@test.com", "654-9852");
//		System.out.println("Total Join Success Number : " + main.dao.getNum());
		
		memberT01.mainUpdate("Three", "Ronaldo", "1547", "Madrid", "Ronaldo@test.com", "123-1234");
		// first string value(id) is primary key, not changed, unique of record.
	}
	
}
