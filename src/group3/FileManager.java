package group3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
	int count = 0;
	Scanner scanner = new Scanner(System.in);
	Data data = new Data();
//	Data[] arrData = new Data[10];
	
	List<Data> listData = new ArrayList<Data>();
	

	public void insert() {

		System.out.print("이름 : ");
		data.setName(scanner.nextLine());
		System.out.print("주소 : ");
		data.setAddress(scanner.nextLine());
		System.out.print("연락처 : ");
		data.setTelephone(scanner.nextLine());
		System.out.print("메일 : ");
		data.setEmail(scanner.nextLine());

//		arrData[count] = new Data();
		
		listData.add(count, new Data(data.getName(), data.getAddress(), data.getTelephone(), data.getEmail()));

//		arrData[count].setName(data.getName());
//		arrData[count].setAddress(data.getAddress());
//		arrData[count].setTelephone(data.getTelephone());
//		arrData[count].setEmail(data.getEmail());

//		System.out.print(arrData[count].getName() + " ");
//		System.out.print(arrData[count].getAddress() + " ");
//		System.out.print(arrData[count].getTelephone() + " ");
//		System.out.println(arrData[count].getEmail() + " ");

		System.out.println("성공적으로 입력되었습니다." + "\n");
		count++;
	}

	public void update() {

	}

	public void delete() {

	}

	public void select() {
		for (int i = 0; i < listData.size(); i++) {
			Data data = listData.get(i);
			System.out.println(data.getName() + "\t" + data.getAddress() + "\t" + data.getTelephone() + "\t" + data.getEmail());
		}
		System.out.println("Hello World"+ "\n");
	}

	public void search() {

	}
}
