package com.github.Exterras.chap09;

public class AnonymousEx {
	public static void main(String[] args) {
		Anonymous anonymous = new Anonymous();
		anonymous.field.turnOn(); // interface RemoteControl turnOn()
		anonymous.method1(); // class Anonymous method1()
		anonymous.method2(new RemoteControl() { // interface RemoteControl type turnOn()
			
			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				System.out.println("Smart Tv On");
			}
			
			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				System.out.println("Smart Tv Off");
			}
		});
	}
}
