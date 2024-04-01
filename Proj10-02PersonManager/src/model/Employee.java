package model;

public class Employee extends Person {
	private String ssn;

	public Employee(String firstname, String lastName, String ssn) {
		super(firstname, lastName);
		this.ssn = ssn;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return super.toString() + "\nSSN: xxx-xx-" + ssn.substring(ssn.lastIndexOf("-")+1);
	}
	
	
}
