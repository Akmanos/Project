package teamProject;

//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De León Polanco.
//this class represents a players stats per game or practice
public class Statistics {
	private int pnt; //points
	private int ast; //assists
	private int reb; //rebounds
	private String vs;
	private String result;
	
	public Statistics(int pnt, int ast, int reb) {
		this.pnt = pnt;
		this.ast = ast;
		this.reb = reb;
	}
	
	public Statistics(String vs, String result) {
		this.vs = vs;
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "Points: " + pnt +"\n"
				+ "Assists: " + ast+"\n"
				+"Rebounds: " +reb+"\n";
	}
	public String toStringC() {
		return "vs "+vs+": "+result+"\n";
	}
}
