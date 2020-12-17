package teamProject;

import java.util.ArrayList;
import java.util.HashMap;

//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De León Polanco.
//This class represents a basketball coach

public class Coach extends Athletes{
    private String type;
    private HashMap<String, Player> players;
    private ArrayList<Statistics> stats;
    private Schedule nextEvent;

    public Coach(String name, int age, String id){
        super(name, age, id);
        type = "Coach";
        players = new HashMap<String,Player>();
        stats = new ArrayList<Statistics>();
        nextEvent = new Schedule();
    }

	public String getType(){
        return type;
    }
    
	public void addPlayer(String id, Player player) {
    	players.put(id, player);
    }
	
	public void getStats() {
		if(stats == null || stats.size() <= 0) {
			System.out.println("No stats to show. Please wait until after a game.\n");
			return;
		}
		
		for(int i = 0; i<stats.size(); i++) {
			System.out.println(stats.get(i).toStringC());
		}
	}
	public void addStat(Statistics stats) {
		this.stats.add(stats);
	}
	public Player getPlayer(String id) {
		return players.containsKey(id) ? players.get(id) : null;
	}
	public void removePlayer(String id) {
		players.remove(id);
	}
	public void getEvent() {
		System.out.println(nextEvent.toString());
	}
	public void setEvent(Schedule s) {
		nextEvent = s;
	}
}
