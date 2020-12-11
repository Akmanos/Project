package teamProject;


//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De León Polanco.
//This class represents a basketball coach

public class Coach extends Athletes{
    private String type;

    public Coach(String name, int age, String id){
        super(name, age, id);
        type = "Coach";
    }

    protected void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    protected void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    protected void setID(String id){
        this.id = id;
    }

    public String getID(){
        return id;
    }

    public String getType(){
        return type;
    }

}
