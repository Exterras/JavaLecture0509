package com.github.Exterras.chap08;

public class ActionEx {
	public static void main(String[] args) {
		Action action = new Action(){
			public void work(){
				System.out.println("Copy Work");
			}
		};
		
		action.work();
	}
}
