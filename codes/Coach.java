package teamProject;


//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De León Polanco.
//This class represents a basketball coach

public class Coach extends Athletes{
    private String type;
    private String name;
    private String id;
    private int age;

    public Coach(String name, int age, String id){
        super(name, age, id);
        type = "Coach";
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getType(){
        return type;
    }

}
