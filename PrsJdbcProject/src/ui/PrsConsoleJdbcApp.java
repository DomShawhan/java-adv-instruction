package ui;

import java.util.ArrayList;

import db.Userdb;
import db.VendorDb;
import model.User;
import model.Vendor;

public class PrsConsoleJdbcApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the PRS JDBC Console App!");
		
		// 1 - Get All Users
//		ArrayList<User> users = Userdb.getAll();
//		
//		if(users != null) {
//			System.out.println();
//			System.out.println("List of Users:");
//			System.out.println("==================");
//			for(User u: users) {
//				System.out.println(u);
//			}
//		} else {
//			System.out.println("Error - check logs");
//		}
//		System.out.println();
//		
//		// 2 - Get user by id
//		System.out.println("Get User by id (3)");
//		System.out.println("==================");
//		
//		User user = Userdb.getById(3);
//		if(user != null) {
//			System.out.println(user);
//		} else {
//			System.out.println("Error - check logs");
//		}
//		System.out.println();
//		
//		// 3 - Add a user
//		System.out.println("Add User");
//		System.out.println("==================");
//		
//		User u = new User(0, "rduck", "rduckpas", "Rubber", "Duck", null, null, false, false);
//		if(Userdb.add(u)) {
//			System.out.println("Success - user added");
//		} else {
//			System.out.println("Error - adding user");
//		}
//		System.out.println();
//		
//		// 3 - Delete a user
//		System.out.println("Delete User");
//		System.out.println("==================");
//		
//		if(Userdb.delete(5)) {
//			System.out.println("Success - user added");
//		} else {
//			System.out.println("Error - adding user");
//		}
		
		// Get All Vendors
		System.out.println();
		ArrayList<Vendor> vendors = VendorDb.getAllVendors();
		if(vendors != null) {
			System.out.println("List of Vendors:");
     		System.out.println("==================");
			for(Vendor v: vendors) {
				System.out.println(v);
			}
		} else {
			System.out.println("Error getting all users.");
		}
		System.out.println();
		
		// Get Vendor By Id
		Vendor v = VendorDb.getVendorById(1);
		if(v != null) {
			System.out.println("Vendor Id(2)");
			System.out.println("==================");
			System.out.println(v);
		}
		System.out.println();
		
		// New Vendor
//		Vendor vendor = new Vendor(0, "STPL", "Staples", "123 Main Ave", "Cincinnati", "OH", "45211", "123-456-7890", "support@staples.com");
//		if(VendorDb.add(vendor)) {
//			System.out.println("Vendor added");
//		} else {
//			System.out.println("Error adding vendor");
//		}
//		System.out.println();
		
		//Delete Vendor
		
		if(VendorDb.delete(3)) {
			System.out.println("Vendor(3) deleted");
		} else {
			System.out.println("An error occurred while deleting a vendor");
		}
		
		System.out.println("bye");
	}

}
