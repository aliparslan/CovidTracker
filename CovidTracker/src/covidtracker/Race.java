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
    public Race(String name, String cases, String deaths) {

        this.name = name;

        if (this.checkIfNA(cases) || this.checkIfNA(deaths)) {
            if (this.checkIfNA(cases) && this.checkIfNA(deaths)) {
                this.cases = -1;
                this.deaths = -1;
            }
            else if (this.checkIfNA(cases)) {
                this.cases = -1;
                this.deaths = Integer.valueOf((String)deaths);
            }
            else if (this.checkIfNA(deaths)) {
                this.cases = Integer.valueOf((String)cases);
                this.deaths = -1;
            }
            CFR = -1;
        }
        else {
            this.cases = Integer.valueOf((String)cases);
            this.deaths = Integer.valueOf((String)deaths);
            CFR = (float)(((float)this.deaths / (float)this.cases)*100.0);
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
     * Returns case number
     * 
     * @return int cases
     */
    public int getCases() {
        return cases;
    }
    
    /**
     * Returns death number()
     * @return int deaths
     */
    public int getDeaths() {
        return deaths;
    }
    
    /**
     * Test to see if two races are equal
     * @param Object to compare to 
     * @return if equals
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if (obj.getClass() != this.getClass()) {
            return false;
        }

        else {
            return (this.getName().equals(((Race)obj).getName())
                && this.getCases() == ((Race)obj).getCases()
                && this.getDeaths() == ((Race)obj).getDeaths());
        }
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
