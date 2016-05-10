package com.github.Exterras.chap08;

public interface ChildInterface3 extends ParentInterface{
	public void method3();
	
	ChildInterface3 ci3 = new ChildInterface3() {
		
		@Override
		public void method1() {
			// TODO Auto-generated method stub
			System.out.println("ChildInterface3 method1");
		}
		
		@Override
		public void method2() {
			// TODO Auto-generated method stub
			System.out.println("ChildInterface3 method2");
		}
		
		@Override
		public void method3() {
			// TODO Auto-generated method stub
			System.out.println("ChildInterface3 method3");
		}
	};
	
	public static void main(String[] args) {
		ci3.method1();
		ci3.method2();
		ci3.method3();
	}
}