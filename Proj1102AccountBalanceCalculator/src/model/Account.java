package model;

import interfaces.*;

public abstract class Account implements Depositable, Balanceable, Withdrawable {
	private double balance;

	public Account(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		if(balance >= amount) {
			balance -= amount;
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double amount) {
		balance = amount;
	}
}
