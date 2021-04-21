/**
 * 
 */
package covidtracker;

import student.TestCase;

/**
 * Class to test the race class
 * @author Carly Daffan
 * @version 4.20.21
 */
public class RaceTest extends TestCase {
    private Race race1;
    private Race race2;
    private Race race3;
    private Race race4;
    
    
    /**
     * Set up test cases
     */
    public void setUp() {
        race1 = new Race("White", 50, 10);
        race2 = new Race("Asian","NA",10);
        race3 = new Race("Indian", 150, 110);
        race4 = new Race("LatinX",10,"NA");
    }
    
    /**
     * Tests getCFR()
     */
    public void testGetCFR() {
        assertEquals(race1.getCFR(), .2, 2);
        assertEquals(race2.getCFR(),-1,1);
        assertEquals(race4.getCFR(),-1,1);
        
    }
    
    /**
     * Tests getName()
     */
    public void testGetName() {
        assertEquals(race3.getName(), "Indian");
    }
}
