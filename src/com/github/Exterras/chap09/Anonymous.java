package com.github.Exterras.chap09;

public class Anonymous {
	//field reset
	RemoteControl field = new RemoteControl() {
		
		@Override
		public void turnOn() {
			// TODO Auto-generated method stub
			System.out.println("TV On");
		}
		
		@Override
		public void turnOff() {
			// TODO Auto-generated method stub
			System.out.println("TV Off");
		}
	};
	
	void method1(){
		RemoteControl localVar = new RemoteControl() {
			
			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				System.out.println("Audio On");
			}
			
			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				System.out.println("Audio Off");
			}
		};
		
		localVar.turnOn();
	}
	
	void method2(RemoteControl rc){
		rc.turnOn();
	}
	
}
