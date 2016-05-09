package com.github.Exterras.chap08;

public class ImplementationEx {
	public static void main(String[] args) {
		ImplementationC impl = new ImplementationC();
		
		InterfaceA ia = impl;
		ia.methodA();
//		ia.methodB();
//		ia.methodC();
		
		System.out.println();
		
		InterfaceB ib = impl;
		ib.methodB();
//		ib.methodA();
//		ib.methodC();
		
		System.out.println();
		
		InterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
		
	}
}
