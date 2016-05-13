package com.github.Exterras.chap13;

public class BoxEx {
	public static void main(String[] args) {
		Box box = new Box(); // Object type
		box.set("Hong"); 					// String type -> Objext type
		String name = (String) box.get(); 	// Object type -> String type
		
		box.set(new Apple()); 				// Apple type -> Objext type 
 		Apple apple = (Apple) box.get(); 	// Object type -> Apple type
		
		BoxGeneric<String> box1 = new BoxGeneric<String>();
		box1.set("Hello");
		 String str = box1.get();
	}
}
