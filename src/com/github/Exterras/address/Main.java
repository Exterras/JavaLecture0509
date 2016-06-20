package com.github.Exterras.address;

public class Main {
	public static void main(String[] args) {	
		AddressBook addressBook = new AddressBook();
		while(addressBook.isFlag()){
			addressBook.play();			
		}
	}
}
