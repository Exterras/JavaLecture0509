package com.github.Exterras.chap08;

public class SoundableEx {
	private static void printSound(Soundable soundable) {
		// TODO Auto-generated method stub
		System.out.println(soundable.sound());
	}
	
	public static void main(String[] args) {
		printSound(new Cat());
		printSound(new Dog());
	}
}
