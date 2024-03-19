package ui;

import java.math.RoundingMode;
import java.text.NumberFormat;

import interfaces.Depositable;
import interfaces.Withdrawable;
import model.CheckingAccount;
import model.SavingsAccount;
import utility.Console;

public class AccountBalanceApp {
	static NumberFormat currencyFormat	= NumberFormat.getCurrencyInstance();
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Account application");
		
		CheckingAccount ca = new CheckingAccount(1, 1000);
		SavingsAccount sa = new SavingsAccount(.01, 1000);
		
		currencyFormat.setRoundingMode(RoundingMode.HALF_UP);
		
		System.out.println();
		System.out.println("Starting Balances");
		System.out.println("Checking: " + currencyFormat.format(ca.getBalance()));
		System.out.println("Savings:  " + currencyFormat.format(sa.getBalance()));
		System.out.println();
		
		System.out.println("Enter the transactions for the month");
		String choice = "y";
		
		while(choice.equalsIgnoreCase("y")) {
			System.out.println();
			String action = Console.getString("Withdrawal or deposit? (w/d): ", "w", "d");
			String account = Console.getString("Checking or Savings? (c/s): ", "c", "s");
			double amount = 0;
			
			switch(action) {
			case "w": 
				switch(account) {
				case "c":
					amount = Console.getDouble("Amount: ", 0, ca.getBalance());
					withdraw(ca, amount);
					break;
				case "s":
					amount = Console.getDouble("Amount: ", 0, sa.getBalance());
					withdraw(sa, amount);
					break;
				default:
					System.out.println("Please Enter a valid input.");
					break;
				}
				break;
			case "d":
				amount = Console.getDouble("Amount: ", 0, Double.MAX_VALUE);
				switch(account) {
				case "c":
					deposit(ca, amount);
					break;
				case "s":
					deposit(sa, amount);
					break;
				default:
					System.out.println("Please Enter a valid input.");
					break;
				}
				break;
			default: 
				System.out.println("Please Enter a valid input.");
				break;
			}
			System.out.println();
			choice = Console.getString("Continue? (y/n): ", "y", "n");
		}
		
		outputMonthlyAmounts(ca, sa);

	}
	//Withdraw
	private static void withdraw(Withdrawable w, double amount) {
		w.withdraw(amount);
	}
	//Deposit
	private static void deposit(Depositable d, double amount) {
		d.deposit(amount);
	}
	
	private static void outputMonthlyAmounts(CheckingAccount ca, SavingsAccount sa) {
		// Call methods to add interest and subtract fees
		ca.subtractFee();
		sa.payInterest();
		// Display final amounts
		System.out.println();
		
		System.out.println("Monthly Payments and Fees");
		System.out.println("Checking fee:             " + currencyFormat.format(ca.getMonthlyFee()));
		System.out.println("Savings interest payment: " + currencyFormat.format(sa.getInterestPayment()));
		System.out.println();
		
		System.out.println("Final Balances");
		System.out.println("Checking: " + currencyFormat.format(ca.getBalance()));
		System.out.println("Savings:  " + currencyFormat.format(sa.getBalance()));
	}

}
