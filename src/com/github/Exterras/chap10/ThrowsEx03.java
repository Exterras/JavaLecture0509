package com.github.Exterras.chap10;

import java.io.IOException;

public class ThrowsEx03{
	public static void main(String[] args){
		System.out.println("Input the Text");
		try {
			int vRead = System.in.read();	
			
			if (vRead == 65) { throw new IOException(); }
			
			System.out.println("Input Text Code : "+vRead);
			System.out.println("Input Text : "+(char)vRead);
			
		} catch (IOException e) {
			System.out.println("Error or Input 'A'");
		}
	}
}
