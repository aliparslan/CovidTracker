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
    public Race(String name, Object obj1, Object obj2) {
        this.name = name;
        // nothing here yet
    }
    
    // Methods .......................................
    
    /**
     * 
     */
    public float getCFR() {
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
