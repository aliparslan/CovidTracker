/**
 * 
 */
package covidtracker;

import java.util.Comparator;

/**
 * Comparator for CFR numbers
 * 
 * @author Carly Daffan
 * @version 4.23.21
 */
public class CompareCFR implements Comparator<Race> {
    /**
     * Returns the highest CFR between two Races
     * 
     * @param left
     *            Race first race to compare
     * @param right
     *            Race second race to compare
     * @return int of which Race has the higher CFR
     */
    public int compare(Race left, Race right) {
        if ((left.getCFR() - right.getCFR()) <= 0) {
            return 1;
        }
        else {
            return -1;
        }
    }

}
