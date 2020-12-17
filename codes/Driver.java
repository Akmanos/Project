
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        //create main login
        new Log("main","main1","Coach");
        String type;
        //ask user for type
        System.out.println("Welcome to the log in page...");

        do{

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
                    scan.close();
                    return;
                }
                else{
                    player();
                    scan.close();
                    return;
                }
            }
            else {
                System.out.println("Incorrect login credentials. Try again!");

            }

        }while (!type.equalsIgnoreCase("coach") || (!type.equalsIgnoreCase("player")));
        scan.close();
    }
    //coach menu
    private static void coach() throws IOException {
        String input = "";
        Coach manager = new Coach("Main", 27, "main");
        Scanner scan = new Scanner(System.in);
        while(!input.contentEquals("q")) {
            System.out.println("Enter A to add a player\n"
                + "Enter S to look at Statistics\n"
                + "Enter P to look at a players stats\n"
                + "Enter R to remove a player\n"
                + "Enter C to add/remove a new coach\n"
                + "Enter SS to see schedule\n"
                + "Enter PS to add new stats to a player\n"
                + "Enter Q to quit");
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
                manager.addPlayer(new Player(name, age, id, height, weight));
                System.out.println("Please enter player's password: ");
                String password = scan.next();
                scan.nextLine();
                //create players login
                new Log(id, password, "Player");
                break;
                
                case "s":
                //return whole teams stats
                break;
                
                case "ss":
                // return schedule
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

                default:
                System.out.println("Goodbye");
                scan.close();
            }
        }
    }

    private static void player() {
        Scanner scan = new Scanner(System.in);
        String input;
        do {
            System.out.println("Enter S to look at team stats\n"
                + "Enter P to look at a players stats\n"
                + "Enter SS to see schedule\n"
                + "Enter Q to quit");
            input = scan.hasNext() ? scan.nextLine() : "";

            switch(input.toLowerCase()) {
                case "s":
                //return whole teams stats
                break;
                
                case "ss":
                //return schedule schedule
                break;
                
                case "p":
                //return a given players stats
                System.out.println("Please enter players id: ");
                //call method
                break;

                default:
                System.out.println("Goodbye");
                scan.close();

            }
        }while(!input.equalsIgnoreCase("q"));

    }
}

