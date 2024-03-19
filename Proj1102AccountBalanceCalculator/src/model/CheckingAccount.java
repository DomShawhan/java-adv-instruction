package model;

public class CheckingAccount extends Account {
	private double monthlyFee;

	public CheckingAccount(double monthlyFee, double balance) {
		super(balance);
		this.monthlyFee = monthlyFee;
	}
	
	public void subtractFee() {
		setBalance(getBalance() - monthlyFee);
	}
	
	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}
}
