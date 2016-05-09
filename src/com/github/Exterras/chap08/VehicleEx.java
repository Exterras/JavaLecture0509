package com.github.Exterras.chap08;

public class VehicleEx {
	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		
		vehicle.run();
//		vehicle.checkFare();
		
		Bus bus = (Bus)vehicle;
		
		bus.run();
		bus.checkFare();
		
		
	}
}
