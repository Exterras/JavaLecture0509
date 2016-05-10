package com.github.Exterras.chap08;

public interface ParentInterface {
	public void method1();
	public default void method2(){
		System.out.println("ParentInterface method2");
	}
}
