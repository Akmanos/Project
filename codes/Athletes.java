package teamProject;

//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De León Polanco.


//Make Athletes the main method... and it will be the I/O.
public class Athletes {
    private String name;
    private int age;
    private String id;

    public Athletes(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public  String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;   
    }

    public int getAge(){
        return age;
    }

    public void setID(String id){
        this.id = id;
    }

    public String getID(){
        return id;
    }
}
