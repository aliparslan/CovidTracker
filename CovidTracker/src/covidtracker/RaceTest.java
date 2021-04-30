/**
 * 
 */
package covidtracker;

import student.TestCase;

/**
 * Class to test the race class
 * 
 * @author Carly Daffan
 * @version 4.23.21
 */
public class RaceTest extends TestCase {
    private Race race1;
    private Race race2;
    private Race race3;
    private Race race4;
    private Race race5;
    private Race race6;
    private Race race7;

    /**
     * Set up test cases
     */
    public void setUp() {
        race1 = new Race("White", "50", "10");
        race2 = new Race("Asian", "NA", "10");
        race3 = new Race("Indian", "150", "110");
        race4 = new Race("LatinX", "50", "NA");
        race5 = new Race("White", "50", "10");
        race6 = new Race("Black", "NA", "NA");
        race7 = new Race("Black", "20", "NA");
    }


    /**
     * Tests getCFR()
     */
    public void testGetCFR() {
        assertEquals(race1.getCFR(), 20, 2);
        assertEquals(race2.getCFR(), -1, 1);
        assertEquals(race4.getCFR(), -1, 1);

    }


    /**
     * Tests getName()
     */
    public void testGetName() {
        assertEquals(race3.getName(), "Indian");
    }


    /**
     * Tests getCases()
     */
    public void testGetCases() {
        assertEquals(race3.getCases(), 150);
        assertEquals(race2.getCases(), -1);
        assertEquals(race6.getCases(), -1);
    }


    /**
     * Tests getDeaths()
     */
    public void testGetDeaths() {
        assertEquals(race3.getDeaths(), 110);
        assertEquals(race4.getDeaths(), -1);
        assertEquals(race6.getDeaths(), -1);
        assertEquals(race7.getDeaths(), -1);
    }


    /**
     * Test equals()
     */
    public void testEquals() {
        Race a = null;
        assertFalse(race2.equals(a));
        Object b = new Object();
        assertFalse(race3.equals(b));
        assertFalse(race3.equals(race4));
        assertFalse(race1.equals(race4));
        assertTrue(race1.equals(race5));
        assertTrue(race5.equals(race5));
        assertFalse(race1.equals(race2));
        assertFalse(race2.equals(race4));

        Race c = new Race("White", "40", "10");
        assertFalse(race1.equals(c));

        Race d = new Race("White", "50", "20");
        assertFalse(race1.equals(d));
    }
}
