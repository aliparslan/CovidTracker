/**
 * 
 */
package covidtracker;

import student.TestCase;

/**
 * Class to test the State class
 * 
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
     * tests sortRacesAlpha()
     */
    public void testSortRacesAlpha() {
        Race race1 = new Race("White", "70", "10");
        Race race2 = new Race("Black", "60", "30");
        Race race3 = new Race("Latin", "100", "30");
        Race race4 = new Race("Asian", "70", "10");
        Race race5 = new Race("Other", "60", "10");
        virginia = new State("Virginia", race1, race2, race3, race4, race5);

        virginia.sortRacesAlpha();
        assertEquals(race4, virginia.getRaces().get(0));
        assertEquals(race2, virginia.getRaces().get(1));
        assertEquals(race3, virginia.getRaces().get(2));
        assertEquals(race5, virginia.getRaces().get(3));
        assertEquals(race1, virginia.getRaces().get(4));

    }


    /**
     * tests sortRacesCfr()
     */
    public void testSortRacesCfr() {
        Race race1 = new Race("White", "200", "10");
        Race race2 = new Race("Black", "60", "30");
        Race race3 = new Race("Latin", "100", "30");
        Race race4 = new Race("Asian", "70", "10");
        Race race5 = new Race("Other", "60", "10");
        virginia = new State("Virginia", race1, race2, race3, race4, race5);

        virginia.sortRacesCfr();
        assertEquals(race2, virginia.getRaces().get(0));
        assertEquals(race3, virginia.getRaces().get(1));
        assertEquals(race5, virginia.getRaces().get(2));
        assertEquals(race4, virginia.getRaces().get(3));
        assertEquals(race1, virginia.getRaces().get(4));

    }

}
