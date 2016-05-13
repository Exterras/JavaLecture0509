package com.github.Exterras.chap13;

public class BoxGeneric<String> {
//	private <T> t;
//	public void set(<T> t){
//		this.t = t;
//	}
//	public <T> get(){
//		return t;
//	}
	
	private String str;
	
	public void set(String str){
		this.str = str;
	}
	public String get(){
		return str;
	}
}
