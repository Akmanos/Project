
import java.util.ArrayList;
//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De Leon Polanco.
//This class represents a basketball coach

public class Coach extends Athletes{
    private String type;
    private ArrayList<Player> players;
    private ArrayList<Statistics> teamStat;
    private ArrayList<Schedule> schedules;

    public Coach(String name, int age, String id){
        super(name, age, id);
        type = "Coach";
        players = new ArrayList<Player>();
        teamStat = new ArrayList<Statistics>();
        schedules = new ArrayList<Schedule>();
    }

    public String getType(){
        return type;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
    
    public void addSchedule(Schedule schedule){
        schedules.add(schedule);
    
    }

    public void addStat(String v, String r){
        teamStat.add(new Statistics(v,r));
    }

    public void getStat(){
        for(int i = 0; i < teamStat.size(); i++){

            System.out.println(teamStat.get(i));

        }
    } 
}
