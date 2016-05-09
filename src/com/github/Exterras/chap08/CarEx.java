package com.github.Exterras.chap08;

public class CarEx {
	public static void main(String[] args) {
		Car mycar = new Car();
		mycar.run();
		
//		mycar.frontLeftTire = new KumHoTire();
//		mycar.frontRightTire = new KumHoTire();
		
		mycar.tires[0] = new KumHoTire();
		mycar.tires[1] = new KumHoTire();
		
		mycar.run();
		
	}
}
