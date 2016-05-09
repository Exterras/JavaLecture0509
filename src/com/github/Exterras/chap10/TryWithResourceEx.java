package com.github.Exterras.chap10;

public class TryWithResourceEx {
	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("file.txt")){
			fis.read();
			throw new Exception();
		} catch (Exception e) {
			System.out.println("Exception Code Executed");
		}
	}
}
