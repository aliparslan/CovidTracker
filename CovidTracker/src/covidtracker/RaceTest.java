/**
 * 
 */
package covidtracker;

import student.TestCase;

/**
 * @author Carly Daffan
 *
 */
public class RaceTest extends TestCase {
    private Race race1;
    private Race race2;
    private Race race3;
    
    public void setUp() {
        race1 = new Race("White", 50, 10);
        race2 = new Race("Mexican", 70, 40);
        race3 = new Race("Indian", 150, 110);
    }
    
    public void testAll() {
        assertEquals(race1.getCFR(), .2);
        assertEquals(race3.getName(), "Indian");
    }
}
