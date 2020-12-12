package teamProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		Coach manager = new Coach("Main", 27, "main");
		
		//ask user for type
		System.out.println("Are you a coach or a player?");
		String type = scan.next();
		//prompt user for login
		System.out.println("Username: ");
		String id = scan.next();
		System.out.println("Password: ");
		id += " "+scan.next();
		//verify credentials
		
		
	}

}
