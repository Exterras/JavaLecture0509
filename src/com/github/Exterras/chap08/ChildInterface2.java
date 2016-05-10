package com.github.Exterras.chap08;

public interface ChildInterface2 extends ParentInterface{
	public void method3();
	
	ChildInterface2 ci2 = new ChildInterface2() {
		
		@Override
		public void method1() {
			// TODO Auto-generated method stub
			System.out.println("ChildInterface2 method1");
		}
		
		@Override
		public void method3() {
			// TODO Auto-generated method stub
			System.out.println("ChildInterface2 method3");
		}
	};
	
	public static void main(String[] args) {
		ci2.method1();
		ci2.method2();
		ci2.method3();
	}
}