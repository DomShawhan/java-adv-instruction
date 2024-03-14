package ui;

import java.util.Scanner;

import model.Contact;
import util.Console;

public class ContactListApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Contact List App!");

//		Contact c1 = new Contact();
//		c1.setFirstName("George");
//		c1.setLastName("McFly");
//		c1.setEmail("george@b2f.com");
//		c1.setPhone("444-444-4444");
//		
//		Contact c2 = new Contact("FirstName", "LastName", "Email", "Phone");
//		
//		System.out.println(c1.getFirstName());
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		String firstName = Console.getString("Enter First Name: ");
		String lastName = Console.getString("Enter Last Name:  ");
		String email = Console.getString("Enter Email:      ");
		String phone = Console.getString("Enter Phone:      ");
		
		Contact contact = new Contact(firstName, lastName, email, phone);
		
		System.out.println(contact.displayContact());
		
		
		System.out.println("Bye");
	}

}
