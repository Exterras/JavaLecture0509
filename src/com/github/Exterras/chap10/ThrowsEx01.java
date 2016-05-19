package com.github.Exterras.chap10;

import java.io.IOException;

public class ThrowsEx01{
	public static void main(String[] args) throws IOException{
		System.out.println("Input the Text");
		int vRead = System.in.read();
		System.out.println("Input Text Code : "+vRead);
		System.out.println("Input Text : "+(char)vRead);
	}
}
