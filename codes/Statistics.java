
//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De Leon Polanco.
//this class represents a players stats per game or practice
public class Statistics {
    private int pnt; //points
    private int ast; //assists
    private int reb; //rebounds
    private double pntavg; //point average
    private double astavg;
    private double rebavg;
    private String teamName;
    private String result;

    public Statistics(int pnt, int ast, int reb, double pntavg, double astavg, double rebavg) {
        this.pnt = pnt;
        this.ast = ast;
        this.reb = reb;
        this.pntavg = pntavg;
        this.astavg = astavg;
        this.rebavg = rebavg;
    }

    public Statistics(String tN, String g){
        teamName = tN;
        result = g;
    }

    @Override
    public String toString(){

        return teamName + ": " + result ;
    }

}
