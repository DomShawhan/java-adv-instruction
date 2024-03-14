package model;

public class Grade {
	private int number;

	public Grade() {
		this.number = 0;
	}
	
	public Grade(int grade) {
		this.number = grade;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getLetter() {
		if(number <= 60) {
			return "F";
		} else if(number <= 67) {
			return "D";
		} else if(number <= 79) {
			return "C";
		} else if(number <= 87) {
			return "B";
		} else {
			return "A";
		}
	}
}
