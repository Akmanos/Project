package teamProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//create main login
		new Log("main","main1","Coach");
		
		//ask user for type
		System.out.println("Are you a coach or a player?");
		String type = scan.next();
		if(!type.toLowerCase().contentEquals("coach") || 
				!type.toLowerCase().contentEquals("player")) {
			System.out.println(type + " is not an acceptable type. Goodbye!");
			scan.close();
			return;
		}
		//prompt user for login
		System.out.println("Username: ");
		String id = scan.next();
		System.out.println("Password: ");
		id += " "+scan.next();
		//verify credentials
		if(Log.verify(id, type)) {
			//give access to functions for their type
			if(type.toLowerCase().contentEquals("coach")) 
				coach();
			else
				player();
			scan.close();
		}
		else {
			System.out.println("Incorrect login credentials");
		}
		scan.close();
	}
	//coach menu
	private static void coach() throws IOException {
		String input = "";
		Coach manager = new Coach("Main", 27, "main", "Coach");
		Scanner scan = new Scanner(System.in);
		while(!input.contentEquals("q")) {
			System.out.println("Enter A to add a player\n"
					+ "Enter S to look at team stats\n"
					+ "Enter P to look at a players stats\n"
					+ "Enter R to remove a player\n"
					+ "Enter C to add a new coach\n"
					+ "Enter PS to add new stats to a player\n"
					+ "Enter Q to quit");
			input = scan.hasNext() ? scan.next() : "";
			//check user input
			switch(input.toLowerCase()) {
			case "a":
				System.out.println("Please enter players full name: ");
				String name = scan.nextLine();
				System.out.println("Please enter players age: ");
				int age = scan.nextInt();
				System.out.println("Please enter players id: ");
				String id = scan.next();
				System.out.println("Enter player height: ");
				int height = scan.nextInt();
				System.out.println("Enter player's weight: ");
				int weight = scan.nextInt();
				//create player
				manager.addPlayer(new Player(name, age, id, height, weight));
				System.out.println("Please enter player's password: ");
				String password = scan.next();
				//create players login
				new Log(id, password, "Player");
				break;
			case "s":
				//return whole teams stats
				break;
			case "p":
				//return a given players stats
				System.out.println("Please enter players id: ");
				//call method
				break;
			case "r":
				//remove a player
				System.out.println("Please enter players id: ");
				break;
			case "c":
				//create a new coach
				//basically copy paste switch case a but change type to Coach
				break;
			case "ps":
				//get a player by id and add stats to player
			case "q":
				scan.close();
			default:
					System.out.println("Goodbye");
			}
		}
	}
	private static void player() {
		
	}
}
