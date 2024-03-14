import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Scanner;

public class TipCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Tip Calculator App!");
		Scanner scanner = new Scanner(System.in);
		String choice = "y";
		// while loop - while choice = "y" or "Y"
		while(choice.equalsIgnoreCase("y")) {
			
			//1 - prompt for costOfMeal
			System.out.print("Cost of meal: ");
			double costOfMeal = scanner.nextDouble();
			
			NumberFormat pctFormat = NumberFormat.getPercentInstance();
			NumberFormat currencyFormat	= NumberFormat.getCurrencyInstance();
			currencyFormat.setRoundingMode(RoundingMode.HALF_UP);
			
			//2 - do biz logic and display:
			//  - loop through 3 tipPercents: .15, .20, .25
			for(double tipPercent = .15; tipPercent <= .25; tipPercent += .05) {
				//    - calculate tip, totalAmt
				double tip = costOfMeal * tipPercent;
				double totalAmt = costOfMeal + tip;
				//    - Display tipPercent - formatted as a percent
				System.out.println(pctFormat.format(tipPercent));
				//    - Display tipAmount - formatted as currency
				System.out.println("Tip Amount:\t" + currencyFormat.format(tip));
				//	  - Display totalAmount - formatted as currency
				System.out.println("Total Amount:\t"+ currencyFormat.format(totalAmt));
			}
			
			//3 - end while loop - prompt for continue?
			System.out.print("Continue? (y/n) ");
			choice = scanner.next();
		}
		
		System.out.println("Bye");
	}

}
