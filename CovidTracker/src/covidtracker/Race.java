package covidtracker;

/**
 * 
 * @author aliparslan
 * @version 04.16.2021
 *
 */
public class Race implements Comparable {

    // Fields ........................................

    private String name;
    private float CFR;

    // Constructor ...................................

    /**
     * 
     */
    public Race(String name, int deaths, int cases) {
        this.name = name;
        this.CFR = deaths / cases;
    }

    // Methods .......................................

    /**
     * 
     */
    public float getCFR() {
        // example comment
        // something something
        // random comment
        return this.CFR;
    }

    /**
     * 
     */
    public boolean checkNA(Object obj) {
        return true;
        // TODO nothing here yet
    }

    /**
     * 
     */
    public int compareTo(Object arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

}
