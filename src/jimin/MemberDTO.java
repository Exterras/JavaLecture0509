package jimin;

public class MemberDTO {
	private 	String	id;
	private	String	name;
	private	String	pwd;
	private	String	addr;
	private	String	email;
	private	String	phone;
	
	MemberDTO( String id, String name,	String pwd,	String	addr,	String	email,	String	phone){
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.addr = addr;
		this.email = email;
		this.phone = phone;
	}

	
	public MemberDTO(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	

}