package com.github.Exterras.chap08;

public interface ChildInterface1 extends ParentInterface{
	public void method3();
	
	ChildInterface1 ci1 = new ChildInterface1() {
		
		@Override
		public void method1() {
			// TODO Auto-generated method stub
			System.out.println("ChildInterface1 method1");
		}
		
		@Override
		public void method3() {
			// TODO Auto-generated method stub
			System.out.println("ChildInterface1 method3");
		}
	};
	
	public static void main(String[] args) {
		ci1.method1();
		ci1.method2();
		ci1.method3();
	}
}
