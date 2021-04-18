/**
 * 
 */
package covidtracker;

import java.util.Comparator;

/**
 * Comparator for CFR numbers
 * @author Carly Daffan
 * @version 4.18.21
 */
public class CompareCFR implements Comparator<Race> {
    /**
     * Returns the highest CFR
     * 
     * @return int of which Race has the higher CFR
     */
    public int compare(Race left, Race right) {
        return (int)(left.getCFR()-right.getCFR());
    }

}
