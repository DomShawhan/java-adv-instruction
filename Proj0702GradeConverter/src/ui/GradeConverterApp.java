package ui;

import model.Grade;
import util.Console;

public class GradeConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Letter Grade Converter");
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			System.out.println();
			Grade grade = new Grade(Console.getInt("Enter numerical grade: ", -1, 101));
			
			System.out.println("Letter grade: " + grade.getLetter());
			System.out.println();
			choice = Console.getString("Continue? (y/n): ", "y", "n");
		}
		
		System.out.println("Bye");
	}

}
