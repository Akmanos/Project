
//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De León Polanco.
//this class represents a season's schedule
public class Schedule {
    
    private String type = "Default";
    private String date = "12/31";
    
    public Schedule(String dayType, String date){
        this.type = dayType;
        this.date = date;
    }

    public String getDayType(){
        return this.type;
    }

    public void setDayType(String dayt){
        this.type = dayt;
    }

    public String getDate(){
        return this.date;
    }

    public void setDate(String datet){
        this.date = datet;
    }
}
