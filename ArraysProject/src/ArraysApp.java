import java.util.Iterator;

public class ArraysApp {

	public static void main(String[] args) {
		System.out.println("Welcome");
		
		// work with an array of ints
		int[] monthsOfYear = new int[12];
		monthsOfYear[0] = 1;
		monthsOfYear[1] = 2;
		monthsOfYear[2] = 3;
		monthsOfYear[3] = 4;
		monthsOfYear[4] = 5;
		monthsOfYear[5] = 6;
		monthsOfYear[6] = 7;
		monthsOfYear[7] = 8;
		monthsOfYear[8] = 9;
		monthsOfYear[9] = 10;
		monthsOfYear[10] = 11;
		monthsOfYear[11] = 12;
		
		for(int i = 0; i < monthsOfYear.length; i++) {
			System.out.println("i = " + i +", Month = " + monthsOfYear[i]);
		}
		
		// array of doubles
		double[] prices = {5.99, 12.50, 100.25, 11.11};
		
		for (Double price : prices) {
			System.out.println("Price = " + price);
		}
		// work with an array of Strings
		String[] sevenDwarves = {"Bashful", "Dopey", "Happpppppy", "Sneezy","Doc", "Sleepy", "Grumpy"};
		
		for(String d: sevenDwarves) {
			System.out.println(d);
		}
		
		sevenDwarves[2] = "Happy";
		
		for(String d: sevenDwarves) {
			System.out.println(d);
		}
		
		System.out.println("Bye");

	}

}
