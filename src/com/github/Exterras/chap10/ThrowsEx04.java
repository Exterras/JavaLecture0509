package com.github.Exterras.chap10;

import java.io.IOException;

class mNeverA extends Exception{
	mNeverA(){
		System.out.println("Not Input 'A'");
	}
}


public class ThrowsEx04{
	public static void main(String[] args){
		System.out.println("Input the Text");
		try {
			int vRead = System.in.read();	
			
			if (vRead == 65) { throw new mNeverA(); }
			
			System.out.println("Input Text Code : "+vRead);
			System.out.println("Input Text : "+(char)vRead);
			
		} catch (IOException e) {
			System.out.println("Error or Input 'A'");
		} catch (mNeverA a) {
			
		}	
	}
}
