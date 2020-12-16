 

import java.util.ArrayList;

//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De León Polanco.
//This class represents a basketball coach

public class Coach extends Athletes{
    private String type;
    private ArrayList<Player> players;

    public Coach(String name, int age, String id){
        super(name, age, id);
        type = "Coach";
        players = new ArrayList<Player>();
    }

	public String getType(){
        return type;
    }
    
	public void addPlayer(Player player) {
    	players.add(player);
    }
}
