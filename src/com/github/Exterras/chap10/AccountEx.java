package com.github.Exterras.chap10;

public class AccountEx {
	public static void main(String[] args) {
		Account account = new Account();
		
		// Deposing 
		account.deposit(10000);
		System.out.println("Deposit : "+account.getBalance());
		
		// Withdrawing
		try {
			account.withdraw(30000);
		} catch (BalanceInsufficientException e) {
			String message = e.getMessage();
			System.out.println(message);
			System.out.println();
			
//			e.printStackTrace();
		}
	}
}
