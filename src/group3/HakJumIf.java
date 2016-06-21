package group3;

import java.util.Scanner;

public class HakJumIf {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String credit = null;
		
		System.out.print("이름=");
		String name = scanner.nextLine();
		System.out.print("학과=");
		String dept = scanner.nextLine();
		System.out.print("학번=");
		String stuNum = scanner.nextLine();
		System.out.print("점수를 입력하세요 : ");
		int score = scanner.nextInt();
		
		System.out.print(name+"님의 학점은 ");
		
		if (score >= 95 && score <=100) {
			credit = "A+";
			System.out.println(credit+"입니다. 정말 잘했어요");
		} else if (score >= 90 && score <=94) {
			credit = "A0";
			System.out.println(credit+"입니다. 잘했어요");
		} else if (score >= 85 && score <=89) {
			credit = "B+";
			System.out.println(credit+"입니다. 조금만 더 노력하세요");
		} else if (score >= 80 && score <=84) {
			credit = "B0";
			System.out.println(credit+"입니다. 더 노력하세요");
		} else if (score >= 75 && score <=79) {
			credit = "C+";
			System.out.println(credit+"입니다. 많이 노력하세요");
		} else if (score >= 70 && score <=74) {
			credit = "C0";
			System.out.println(credit+"입니다. 조금 부족하네요");
		} else if (score >= 65 && score <=69) {
			credit = "D+";
			System.out.println(credit+"입니다. 부족하네요");
		} else if (score >= 60 && score <=64) {
			credit = "D0";
			System.out.println(credit+"입니다. 많이 부족하네요");
		} else {
			credit = "F";
			System.out.println(credit+"입니다. ...");
		}
	}
}
