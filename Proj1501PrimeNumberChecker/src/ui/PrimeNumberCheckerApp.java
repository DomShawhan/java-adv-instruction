package ui;

import java.util.ArrayList;

import util.Console;

public class PrimeNumberCheckerApp {

	public static void main(String[] args) {
		System.out.println("Prime Number Checker");
		String choice = "y";
		
		while(choice.equalsIgnoreCase("y")) {
			System.out.println();
			//Get user input
			int input = Console.getInt("Please enter a number between 1 and 5000: ", 0, 5001);
			ArrayList<Integer> factors = new ArrayList<>();
			
			for(int i = 1; i <= input; i++) {
				//check if input is divisible by i
				if(input % i == 0) {
					factors.add(i);
				}
			}
			
			//Get size of factors array
			int nbrOfFactors = factors.size();
			
			if(nbrOfFactors <= 2) {
				//if number is prime, it has 2 factors: 1 and the number
				System.out.println(input + " is a prime number.");
			} else {
				//if number has more than 2 factors, it is not prime
				System.out.println(input + " is NOT a prime number.");
				System.out.print("It has " + nbrOfFactors + " factors:");
				for(int f: factors) {
					System.out.print(" " + f);
				}
				System.out.println();
			}
			System.out.println();
			
			choice = Console.getString("Try again? (y/n): ", "y", "n");
		}
		
		System.out.println("Bye!");

	}

}
