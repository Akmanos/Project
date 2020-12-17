package teamProject;

import java.util.ArrayList;

//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De León Polanco.
//This class represents a basketball Player

public class Player extends Athletes{
    private String type;
    private double height;
    private int weight;
    private ArrayList<Statistics> stats;

    public Player(String name, int age, String id, double height, int weight){
        super(name, age, id);
        this.type = "Player";
        this.height = height;
        this.weight = weight;
        stats = new ArrayList<Statistics>();
    }

    public String getType(){
        return type;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public double getHeight(){
        return this.height;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return this.weight;
    }
    public void addPstats(Statistics stats) {
    	this.stats.add(stats);
    }
    public void getStats() {
    	if(stats.size() <= 0) {
    		System.out.println("No statistics have been added for " +this.getName());
    		return;
    	}
    	for(int i = 0; i < stats.size(); i++) {
    		System.out.println(stats.get(i).toString());
    	}
    }
}
