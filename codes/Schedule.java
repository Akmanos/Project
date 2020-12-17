package teamProject;

//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De León Polanco.
//this class represents a season's schedule
public class Schedule {
	private String type = "Default";
	private String date = "00/00";
	
	public Schedule(String type, String date) {
		this.type = type;
		this.date = date;
	}

	public Schedule() {
		// TODO Auto-generated constructor stub
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	@Override
	public String toString() {
		return "Next "+type+" is on: " + date+"\n";
	}
}
