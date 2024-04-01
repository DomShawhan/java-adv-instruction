package model;

public class Customer extends Person {
	private String number;

	public Customer(String firstname, String lastName, String number) {
		super(firstname, lastName);
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return super.toString() + "\nCustomer Number: " + number;
	}
	
	
}
