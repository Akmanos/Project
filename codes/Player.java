package teamProject;


//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De Le�n Polanco.
//This class represents a basketball Player

public class Player extends Athletes{
    private String type;
    private int height;
    private int weight;

    public Player(String name, int age, String id, int height, int weight){
        super(name, age, id);
        this.type = "Player";
        this.height = height;
        this.weight = weight;
    }

    public String getType(){
        return type;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight(){
        return this.height;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return this.weight;
    }
}
