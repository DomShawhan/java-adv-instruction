package ui;

import model.Customer;
import model.Employee;
import model.Person;
import utility.Console;

public class PersonManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Person Manager");
		String choice = "y";
		
		while(choice.equalsIgnoreCase("y")) {
			System.out.println();
			String createOption = Console.getString("Create a customer or employee? (c/e): ", "c", "e");
			System.out.println();
			String firstName = Console.getString("First Name: ");
			String lastName = Console.getString("Last Name: ");
			String option = "";
			
			Person person =  new Person(firstName, lastName);
			
			if(createOption.equalsIgnoreCase("c")) {
				option = Console.getString("Customer number: ");
				
				Customer c = new Customer(firstName, lastName, option);
				person = c;
			} else {
				option = Console.getString("SSN: ");
				
				Employee e = new Employee(firstName, lastName, option);
				person = e;
			}
			System.out.println();
			System.out.println(person.toString());
			System.out.println();
			
			choice = Console.getString("Continue? (y/n): ", "y", "n");
		}
		
		System.out.println("Bye");
	}

}
