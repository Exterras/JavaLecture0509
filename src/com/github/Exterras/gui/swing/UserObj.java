package com.github.Exterras.gui.swing;

import java.util.Random;
import java.util.Scanner;

public class UserObj {
	
	public static int getRandom(int chk){
		Random random = new Random();
		return random.nextInt(chk)+1;
	}
	
	public static int getScan(int chk){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
}
