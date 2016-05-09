package com.github.Exterras.chap10;

public class FileInputStream implements AutoCloseable{

	private String file;
	
	public FileInputStream(String file){
		this.file = file;
	}
	
	public void read(){
		System.out.println(file+" Reading");
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(file+" Closing");
	}

}
