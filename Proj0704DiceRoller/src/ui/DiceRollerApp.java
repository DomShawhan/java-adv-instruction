package ui;

import java.util.Scanner;

import model.Dice;

public class DiceRollerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Dice Roller!");
		String choice = "y";
		Scanner sc = new Scanner(System.in);
		
		while(choice.equalsIgnoreCase("y")) {
			Dice dice = new Dice();
			
			dice.roll();
			
			dice.printRoll();
			System.out.println();
			System.out.print("Roll again? (y/n): ");
			choice = sc.nextLine();
		}
		
		sc.close();
		
		System.out.println("Bye");

	}

}
