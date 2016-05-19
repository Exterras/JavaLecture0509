package com.github.Exterras.chap10;

public class BalanceInsufficientException extends Exception{
	public BalanceInsufficientException(){
		
	}
	
	public BalanceInsufficientException(String message){
		super(message);
	}
}
