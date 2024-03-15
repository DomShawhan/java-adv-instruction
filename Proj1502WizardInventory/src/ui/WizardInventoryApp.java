package ui;

import java.util.*;

import util.Console;

public class WizardInventoryApp {

	public static void main(String[] args) {
		System.out.println("The Wizard Inventory Game");
		List<String> commands = new ArrayList<>(Arrays.asList("show", "grab", "edit", "drop", "exit", "help"));
		String command = "";
		
		List<String> items = initializeItems();
		
		printCommand();
		
		
		while(true) {
			System.out.println();
			command = Console.getString("Command: ");
			if(commands.indexOf(command) == -1) {
				System.out.println("Please enter an allowed command.");
				continue;
			}
			
			if(command.equalsIgnoreCase(commands.get(4))) {
				break;
			} else if(command.equalsIgnoreCase(commands.get(0))) {
				show(items);
			} else if(command.equalsIgnoreCase(commands.get(1))) {
				items = grab(items);
			} else if(command.equalsIgnoreCase(commands.get(2))) {
				items = edit(items);
			} else if(command.equalsIgnoreCase(commands.get(3))){
				items = drop(items);
			} else if(command.equalsIgnoreCase(commands.get(5))) {
				System.out.println();
				printCommand();
			}
		}
		
		
		
		System.out.println("Bye!");

	}
	
	public static List<String> initializeItems(){
		List<String> items = new ArrayList<>();
		items.add("wooden staff");
		items.add("wizard hat");
		items.add("cloth shoes");
		
		return items;
	}
	
	public static void printCommand() {
		System.out.println("COMMAND MENU");
		System.out.println("show - Show all items");
		System.out.println("grab - Grab an item");
		System.out.println("edit - Edit an item");
		System.out.println("drop - Drop an item");
		System.out.println("exit - Exit Program");
		System.out.println("help - Display commands");
		
	}
	
	public static void show(List<String> items) {
		for(int i = 0; i < items.size(); i++) {
			System.out.println((i + 1) + ". " + items.get(i));
		}
	}
	
	public static List<String> grab(List<String> items) {
		if(items.size() < 4) {
			String newItem = Console.getString("Name: ");
			System.out.println(newItem + " was added.");
			items.add(newItem);
		} else {
			System.out.println("You can't carry any more items. Drop something first.");
		}
		return items;
	}
	
	public static List<String> edit(List<String> items) {
		if(items.size() > 0) {
			int number = Console.getInt("Number: ", 0, items.size() + 1);
			String updatedName = Console.getString("Updated Name: ");
			
			items.set(number - 1, updatedName);
			System.out.println("Item number " + number + " was updated.");
		}
		
		return items;
	}
	
	public static List<String> drop(List<String> items) {
		if(items.size() > 0) {
			int number = Console.getInt("Number: ", 0, items.size() + 1);
			
			items.remove(number - 1);
		}

		
		return items;
	}
}
