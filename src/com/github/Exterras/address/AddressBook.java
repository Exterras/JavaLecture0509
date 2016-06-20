package com.github.Exterras.address;

import java.util.Scanner;

public class AddressBook {
	private boolean flag = true;

	public boolean isFlag() {
		return flag;
	}

	public void play() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("주소록 프로그램");
		System.out.println("1. 추가");
		System.out.println("2. 수정");
		System.out.println("3. 삭제");
		System.out.println("4. 보기");
		System.out.println("5. 검색");
		System.out.println("6. 종료");

		System.out.print("입력 : ");
		int menuNum = scanner.nextInt();

		menuSelect(menuNum);
	}

	private void menuSelect(int menuNum) {
		FileManager fileManager = new FileManager();
		
		switch (menuNum) {
		case 1:
			System.out.println("[주소록 추가]" + "\n");
			fileManager.insert();
			break;
		case 2:
			System.out.println("[주소록 수정]"+ "\n");
			fileManager.update();
			break;
		case 3:
			System.out.println("[주소록 삭제]"+ "\n");
			fileManager.delete();
			break;
		case 4:
			System.out.println("[주소록 보기]"+ "\n");
			fileManager.select();
			break;
		case 5:
			System.out.println("[주소록 검색]"+ "\n");
			fileManager.search();
			break;
		case 6:
			System.out.println("프로그램을 종료하겠습니다.");
			flag = false;
			break;
		default:
			System.out.println("잘못 누르셨습니다."+ "\n");
			break;
		}
	}
}
