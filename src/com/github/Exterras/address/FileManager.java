package com.github.Exterras.address;

import java.util.Scanner;

public class FileManager {
	
	Scanner scanner = new Scanner(System.in);
	Data data = new Data();
	
	public void insert() {
		System.out.print("이름 : ");
		data.setName(scanner.nextLine());
		System.out.print("주소 : ");
		data.setAddress(scanner.nextLine()); 
		System.out.print("연락처 : ");
		data.setTelephone(scanner.nextLine()); 
		System.out.print("메일 : ");
		data.setEmail(scanner.nextLine()); 
		System.out.println("성공적으로 입력되었습니다." + "\n");
	}

	public void update() {

	}

	public void delete() {

	}

	public void select() {

	}

	public void search() {

	}
}
