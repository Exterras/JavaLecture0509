package com.github.Exterras.chap08;

public class Car {
//	Tire frontLeftTire = new HanKookTire();
//	Tire frontRightTire = new HanKookTire();
//	Tire backLeftTire = new HanKookTire();
//	Tire backRightTire = new HanKookTire();
//	
	Tire[] tires = {
			new HanKookTire(),
			new HanKookTire(),
			new HanKookTire(),
			new HanKookTire()
	};
	
	void run(){
//		frontLeftTire.roll();
//		frontRightTire.roll();
//		backLeftTire.roll();
//		backRightTire.roll();
		
		for (int i = 0; i < tires.length; i++) {
			tires[i].roll();
		} // case 1
		
//		for (Tire tire : tires) {
//			tire.roll();
//		} case 2
	}
	
}
