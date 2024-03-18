package ui;

import java.security.PublicKey;
import java.time.*;
import java.util.*;


import model.*;
import util.Console;

public class PrsConsoleApp {

	public static void main(String[] args) {
		final String COMMAND_SHOW_ALL_USER = "show all users"; 
		final String COMMAND_ADD_USER = "add user"; 
		final String COMMAND_GET_USER = "get one user"; 
		final String COMMAND_EXIT = "exit"; 
		String command = "";
		System.out.println("Hello PRS");
		System.out.println();
		
		List<User> users = populateUsers();
		
		printMenu();
		while(true) {
			boolean exit = false;
			System.out.println();
			command = Console.getString("Command: ");
			
			switch(command) {
			case COMMAND_SHOW_ALL_USER:
				showAllUsers(users);
				break;
			case COMMAND_ADD_USER: 
				users = addUser(users);
				break;
			case COMMAND_GET_USER:
				getUser(users);
				break;
			case COMMAND_EXIT:
				exit = true;
				break;
			default:
				System.out.println("Please enter a value from the list of available commands.");
				break;
			}
			
			if(exit) {
				break;
			}
		}
		
		/*
		Vendor v1 = new Vendor(1, "mCENTER", "MicroCenter", "123 Main St.", "Cincinnati", "OH", "41015", 
				"123-456-7890", "support@microcenter.com");
		Product p1 = new Product(1, v1, "1T16RL", "Laptop", 799.99, "EA", null);
		
		Request r1 = new Request(1, u1, "New Laptop", "Old one broke", LocalDate.parse("2024-06-04"),
				"Pickup", "Active", 50, null);
		
		LineItem li1 = new LineItem(1, r1, p1, 2);
		
		System.out.println("Users");
		System.out.println("===========================");
		System.out.println(u1);
		System.out.println(u2.toString());
		System.out.println();
		System.out.println("Products");
		System.out.println("===========================");
		System.out.println(p1.toString());
		System.out.println();
		System.out.println("Vendors");
		System.out.println("===========================");
		System.out.println(v1.toString());
		System.out.println();
		System.out.println("Requests");
		System.out.println("===========================");
		System.out.println(r1.toString());
		System.out.println();
		System.out.println("Line Items");
		System.out.println("===========================");
		System.out.println(li1.toString());
		System.out.println();
		System.out.println("bye");
		*/
		
		System.out.println("Bye!");
	}
	
	private static void getUser(List<User> users) {
		int userID = Console.getInt("Enter User ID: ", 0, users.size() + 1);
		
		for(User u: users) {
			if(u.getId() == userID) {
				System.out.println(u);
			}
		}
	}

	private static void showAllUsers(List<User> users) {
		for(int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}
	}
	
	private static List<User> addUser(List<User> users) {
		User user = new User();
		user.setId(users.size() + 1);
		user.setFirstname(Console.getString("Enter First Name: "));
		user.setLastname(Console.getString("Enter Last Name: "));
		user.setUsername(Console.getString("Enter Username: "));
		user.setPassword(Console.getString("Enter Password: "));
		user.setPhone(Console.getString("Enter Phone Nbr: "));
		user.setEmail(Console.getString("Enter Email: "));
		user.setAdmin(false);
		user.setReviewer(false);
		
		users.add(user);
		
		return users;
	}

	private static List<User> populateUsers() {
		User u1 = new User(1, "moose", "not4U2know", "Stuffed", "Moose", "123-456-7890", "moose@glacier.com",
				false, false);
		User u2 = new User(2, "mrbison", "not4U2know", "Stuffed", "Bison", "098-765-4321", "mrbison@mr.com",
				false, false);
		User u3 = new User(3, "thefox", "not4U2know", "Random", "Fox", "456-123-7980", "random@fox.com",
				false, false);
		List<User> users = new ArrayList<>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		return users;
	}
	
	private static void printMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("show all users - Show all users");
		System.out.println("add user - Add a user");
		System.out.println("get one user - Get a user");
		System.out.println("exit - Exit Program");
	}
}
