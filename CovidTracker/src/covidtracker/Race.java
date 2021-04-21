package covidtracker;

/**
 * Creates race objects for each state
 * 
 * @author Matt Wilson
 * @version 04.15.21
 *
 */
public class Race {
    String name;
    int cases;
    int deaths;
    float CFR;

    /**
     * Class constructor
     * 
     * @param name
     *            Race name
     * @param cases
     *            Cases for that race
     * @param deaths
     *            Deaths for that race
     */
    public Race(String name, Object cases, Object deaths) {

        this.name = name;

        if (this.checkIfNA(cases) || this.checkIfNA(deaths)) {
            if (this.checkIfNA(cases) && this.checkIfNA(deaths)) {
                this.cases = -1;
                this.deaths = -1;
            }
            if (this.checkIfNA(cases)) {
                this.cases = -1;
                this.deaths = (int)deaths;
            }
            if (this.checkIfNA(deaths)) {
                this.cases = (int)cases;
                this.deaths = -1;
            }
            CFR = -1;
        }
        else {
            CFR = (float)((int)deaths) / (float)((int)cases);
        }

    }


    /**
     * Returns the calculated CFR
     * 
     * @return CFR
     */
    public float getCFR() {
        return CFR;
    }
    
    /**
     * Returns race's name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Checks to see if the value passed in is a string "NA"
     * 
     * @param value
     * @return boolean if is NA
     */
    private boolean checkIfNA(Object value) {
        if (value.equals("NA")) {
            return true;
        }
        else
            return false;
    }


}
