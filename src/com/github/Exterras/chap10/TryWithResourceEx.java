package com.github.Exterras.chap10;

public class TryWithResourceEx {
	public static void main(String[] args) {
//	  FileInputStream fis = null;
	 	try (FileInputStream fis = new FileInputStream("file.txt")) { // java 7
//	    try{
//			fis = new FileInputStream("file.txt"); // ~ java 6
			fis.read();
//			fis.close(); // ~ java 6
			throw new Exception();
		} catch (Exception e) {
			System.out.println("Exception Code Executed");
		}
	}
}
