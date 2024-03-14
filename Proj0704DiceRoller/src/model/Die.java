package model;

public class Die {
	private int value;
	
	Die() {
		value = 0;
	}
	
	public void roll() {
		value = (int) (Math.random() * 6) + 1;
	}
	
	public int getValue() {
		return value;
	}
}
