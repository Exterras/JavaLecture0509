package com.github.Exterras.chap10;

public class TryCatchFinallyEx {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("java.lang.String2");
		} catch (ClassNotFoundException e) {
			System.out.println("Class is not existed");
		}
	}
}
