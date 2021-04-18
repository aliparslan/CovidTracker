/**
 * 
 */
package covidtracker;
import java.util.Comparator;
/**
 * @author Carly Daffan
 *@version 4.18.21
 */
public class CompareAlpha implements Comparator<Race> {

    public int compare(Race left, Race right) {
        return left.getName().compareTo(right.getName());
    }
}
