/**
 * 
 */
package covidtracker;

import java.util.Comparator;

/**
 * Comparator for Race names
 * 
 * @author Carly Daffan
 * @version 4.18.21
 */
public class CompareAlpha implements Comparator<Race> {
    /**
     * Returns the name which is closer to the beginning of the alphabet
     * 
     * @return int of which Race has the name closer to the beginning of the
     *         alphabet
     */
    public int compare(Race left, Race right) {
        return left.getName().compareTo(right.getName());
    }
}
