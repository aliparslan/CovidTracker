/**
 * 
 */
package covidtracker;

import student.TestCase;

/**
 * @author Carly Daffan
 * @version 4.23.21
 */
public class StateTest extends TestCase {
    private State virginia;
    private State georgia;
    private State northCarolina;

    /**
     * initilizes races for the state objects and
     * initilizes the states with the races in each
     */
    public void setUp() {
        Race race1 = new Race("White", "70", "10");
        Race race2 = new Race("Black", "60", "30");
        Race race3 = new Race("Latin", "100", "30");
        Race race4 = new Race("Asian", "70", "10");
        Race race5 = new Race("Other", "60", "10");
        virginia = new State("Virginia", race1, race2, race3, race4, race5);
        georgia = new State("Georgia", race3, race5, race4, race1, race2);
        northCarolina = new State("North Carolina", race5, race4, race3, race3,
            race1);
    }


    /**
     * test getName method
     */
    public void testGetName() {
        assertEquals(virginia.getName(), "Virginia");
        assertFalse(georgia.getName().equals("Virginia"));
    }


    /**
     * test equals method
     */
    public void testEquals() {
        State a = null;
        assertFalse(georgia.equals(a));
        Object b = new Object();
        assertFalse(northCarolina.equals(b));
        assertTrue(virginia.equals(virginia));
    }
    
    /**
     * tests compareTo()
     */
    public void testCompareTo() {
        // i don't think we'll end up keeping this test
        assertEquals(0, virginia.compareTo(georgia));
    }
}
