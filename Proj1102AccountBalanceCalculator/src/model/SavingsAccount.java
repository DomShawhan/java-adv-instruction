package model;

public class SavingsAccount extends Account {
	private double rate;
	private double interestPayment;
	
	public SavingsAccount(double rate, double balance) {
		super(balance);
		this.rate = rate;
	}
	
	public void payInterest() {
		interestPayment = getBalance() * rate;
		setBalance(interestPayment + getBalance());
	}
	
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getInterestPayment() {
		return interestPayment;
	}
}
