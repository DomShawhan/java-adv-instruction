package ui;

import java.time.*;

import model.*;

public class PrsConsoleApp {

	public static void main(String[] args) {
		System.out.println("Hello PRS");
		System.out.println();
		User u1 = new User(1, "moose", "not4U2know", "Stuffed", "Moose", "123-456-7890", "moose@glacier.com",
				false, false);
		User u2 = new User(2, "mrbison", "not4U2know", "Stuffed", "Bison", "098-765-4321", "mrbison@mr.com",
				false, false);
		
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
	}
}
