package teamProject;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Driver {
	private static Coach manager = new Coach("Main", 27, "main");
	private static boolean quit = false;
	private static Scanner scan = new Scanner(System.in);
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        //create main login
        //new Log("main","main1","Coach");
        String type = "";
        String input = "";
        //ask user for type
        System.out.println("Welcome to the log in page...");

        while ((!type.equalsIgnoreCase("coach") || (!type.equalsIgnoreCase("player"))) && !quit ){

            System.out.println("Are you a coach or a player?");

            type = scan.nextLine();
            type = type.toLowerCase();
            if(!type.contentEquals("coach") && 
            !type.contentEquals("player")) {

                System.out.println(type + " is not an acceptable type. Try again!");
                continue;
            }
            //prompt user for login
            System.out.println("Username: ");
            String id = scan.nextLine();
            System.out.println("Password: ");
            id += " "+scan.nextLine();
            //verify credentials
            type = type.contentEquals("coach") ? "Coach" : "Player";

            if(Log.verify(id, type)) {
                //give access to functions for their type
                if(type.equalsIgnoreCase("coach")){ 
                    coach();
                }
                else{
                    player();
                }
            }
            else {
                System.out.println("Incorrect login credentials. Try again!");
            }
            System.out.println("Shut down program? Yes/No /t any other input will be taken as NO!");
            input = scan.nextLine();
            quit = input.equalsIgnoreCase("Yes") ? true : false;
        }
        scan.close();
    }
    
    
    //coach menu
    private static void coach() throws IOException {
        String input = "";
        while(!input.contentEquals("q")) {
            System.out.println("Enter A to add a player\n"
                + "Enter S to look at team Statistics\n"
                + "Enter P to look at a players statistics\n"
                + "Enter R to remove a player\n"
                + "Enter C to add a new coach\n"
                + "Enter SS to see schedule\n"
                + "Enter PS to add new statistics to a player\n"
                + "Enter T to add game results\n"
                + "Enter NE to set next scheduled event\n"
                + "Enter Q to logout");
            input = scan.hasNext() ? scan.next() : "";
            scan.nextLine();
            //check user input
            switch(input.toLowerCase()) {
                case "a":
                	System.out.println("Please enter players full name: ");
                	String name = scan.nextLine();
                	System.out.println("Please enter players age: ");
                	int age = scan.nextInt();
                	scan.nextLine();
                	System.out.println("Please enter players id: ");
                	String id = scan.next();
                	scan.nextLine();
                	System.out.println("Enter player height: ");
                	double height = scan.nextDouble();
                	scan.nextLine();
                	System.out.println("Enter player's weight: ");
                	int weight = scan.nextInt();
                	scan.nextLine();
                	//create player
                	manager.addPlayer(id, new Player(name, age, id, height, weight));
                	System.out.println("Please enter player's password: ");
                	String password = scan.next();
                	scan.nextLine();
                	//create players login
                	new Log(id, password, "Player");
                	break;
                
                case "s":
                //return whole teams stats
                	manager.getStats();
				try {
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                	break;
                
                case "ss":
                // return schedule
                	manager.getEvent();
                	break;
                
                case "p":
                	//return a given players stats
                	System.out.println("Please enter players id: ");
                	String id1 = scan.nextLine();
                	//call method
                	if(manager.getPlayer(id1) != null) {
                		System.out.println(manager.getPlayer(id1).getName());
                		manager.getPlayer(id1).getStats();
                	}
                	else { System.out.println("Invalid id");}
                	break;
                
                case "r":
                	//remove a player
                	System.out.println("Please enter players id: ");
                	id1 = scan.nextLine();
                	//call method
                	if(manager.getPlayer(id1) != null) {
                		System.out.println(manager.getPlayer(id1).getName() +"was removed");
                		manager.removePlayer(id1);
                	}
                	else { System.out.println("Invalid id");}
                	break;
                
                case "c":
                	//create a new coach
                	System.out.println("Please enter coach's full name: ");
                	name = scan.nextLine();
                	System.out.println("Please enter coach's age: ");
                	age = scan.nextInt();
                	scan.nextLine();
                	System.out.println("Please enter coach's id: ");
                	id = scan.next();
                	scan.nextLine();
                	//create coach
                	new Coach(name, age, id);
                	System.out.println("Please enter coach's password: ");
                	password = scan.next();
                	scan.nextLine();
                	//create coach login
                	new Log(id, password, "Player");
                	break;
                
                case "ps":
                	//get a player by id and add stats to player
                	System.out.println("Please enter players id: ");
                	id1 = scan.nextLine();
                	//call method
                	if(manager.getPlayer(id1) != null) {
                		System.out.println("How many points did " + manager.getPlayer(id1).getName() +
                				" score?");
                		int pnt = scan.nextInt(); scan.nextLine();
                		System.out.println("How many assists: ");
                		int ast = scan.nextInt(); scan.nextLine();
                		System.out.println("How many Rebound: ");
                		int reb = scan.nextInt(); scan.nextLine();
                		manager.getPlayer(id1).addPstats(new Statistics(pnt, ast, reb));
                	}
                	else { System.out.println("Invalid id");}
                	
                	break;
                case "t":
                	System.out.println("What team did you go against? ");
                	String vs = scan.nextLine();
                	String result = "";
                	
                	while(result.contentEquals("")) {
                		System.out.println("Win or Loss?");
                		result = scan.next();
                		scan.nextLine();
                		result = result.equalsIgnoreCase("Win") || result.equalsIgnoreCase("Lose")
                				? result : "";
                	}
                	manager.addStat(new Statistics(vs, result));
                	break;
                case "ne":
                	//add next scheduled event
                	System.out.println("Is the next event a game/practice?");
                	String type = scan.nextLine();
                	System.out.println("What date is this event? MM/DD");
                	String date = scan.nextLine();
                	manager.setEvent(new Schedule(type, date));
                	break;

                default:
                System.out.println("Goodbye");
            }
        }
    }

    private static void player() {
        String input;
        do {
            System.out.println("Enter S to look at team stats\n"
                + "Enter P to look at your stats\n"
                + "Enter SS to see schedule\n"
                + "Enter Q to logout");
            input = scan.hasNext() ? scan.nextLine() : "";

            switch(input.toLowerCase()) {
                case "s":
                //return whole teams stats
                	manager.getStats();
                	break;
                
                case "ss":
                //return schedule
                	manager.getEvent();
                break;
                
                case "p":
                	//return a given players stats
                	System.out.println("Please enter your id: ");
                	String id1 = scan.nextLine();
                	//call method
                	if(manager.getPlayer(id1) != null) {
                		System.out.println(manager.getPlayer(id1).getName());
                		manager.getPlayer(id1).getStats();
                	}
                	else { System.out.println("Invalid id");}

                default:
                System.out.println("Goodbye");

            }
        }while(!input.equalsIgnoreCase("q"));

    }
}

