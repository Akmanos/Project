package teamProject;

//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De León Polanco.


//Make Athletes the main method... and it will be the I/O.
public abstract class Athletes {
    protected String name;
    protected int age;
    protected String id;

    public Athletes(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    protected abstract void setName(String name);

    public abstract String getName();

    protected abstract void setAge(int age);

    public abstract int getAge();

    protected abstract void setID(String id);

    public abstract String getID();
}
