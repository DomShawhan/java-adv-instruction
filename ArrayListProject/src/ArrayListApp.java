import java.util.ArrayList;
import java.util.List;

public class ArrayListApp {

	public static void main(String[] args) {
		System.out.println("Hello Array List App");
		
		User u1 = new User();
		u1.setFirstname("Bob");
		
		User u2 = new User();
		u2.setFirstname("Sally");
		
		User u3 = new User();
		u3.setFirstname("Gena");
		
		ArrayList<Integer> evenNumbers = new ArrayList<>();
		evenNumbers.add(0);
		evenNumbers.add(2);
		evenNumbers.add(4);
		evenNumbers.add(6);
		
		for(int i: evenNumbers) {
			System.out.println("Even Number: " + i);
		}
		
		List<User> users = new ArrayList<>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
		for(User u: users) {
			System.out.println(u);
		}
		
		System.out.println("bye");
	}

}
