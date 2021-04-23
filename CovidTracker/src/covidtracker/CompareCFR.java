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
     * Returns the highest CFR between two Races
     * 
     * @return int of which Race has the higher CFR
     */
    public int compare(Race left, Race right) {
        if ((left.getCFR()-right.getCFR()) < 0) {
            return 1;
        } else if ((left.getCFR()-right.getCFR()) > 0) {
            return -1;
        } else {
            return 0;
        }
    }

}