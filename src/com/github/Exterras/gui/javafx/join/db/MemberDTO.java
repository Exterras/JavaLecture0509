package com.github.Exterras.gui.javafx.join.db;

public class MemberDTO { 
	 
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	private String addr;

	public MemberDTO() {
		 
	}
	
	public MemberDTO(String id, String pwd) {
		 this(id, pwd, null, null, null, null);
	}
	
	public MemberDTO(String id, String pwd, String name, String addr, String email, String phone) {
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

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}