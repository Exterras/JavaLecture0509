package memberT01;

public class MemberDTO {

	private String id;
	private String pwd;
	private String name;
	private String addr;
	private String email;
	private String phone;
	
	public MemberDTO(){
		
	}
	
	public MemberDTO(String id, String pwd){
		this(id, pwd, null, null, null, null);
	}
	
	public MemberDTO(String id, String pwd, String name, String addr, String email, String phone){
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.addr = addr;
		this.email = email;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
}
