/**
 * 
 */
package covidtracker;

import java.util.Comparator;

/**
 * @author Carly Daffan
 * @version 4.18.21
 */
public class CompareCFR implements Comparator<Race> {
  
    public int compare(Race left, Race right) {
        return (int)(left.getCFR()-right.getCFR());
    }

}
