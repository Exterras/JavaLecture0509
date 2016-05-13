package jimin;

import java.util.Scanner;
import java.util.Random;

public class UserObj {
	
	public static void mLine(int num, int su){
		if( num == 1 ){
			for(int i=0; i<su; i++){
				System.out.print("-");
			}
			System.out.println();
		}else if( num == 2 ){
			for(int i=0; i<su; i++){
				System.out.print("=");
			}
			System.out.println();
		}
	}

	public static int getScan(int chk) {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	public static double getScan(double chk) {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextDouble();
	}
	public static String getScan(String chk) {
		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}

	// �߰��κ� 
	public static int getRandom(int chk) {
		Random	random = new Random();
		return random.nextInt(chk)+1;
	}
}