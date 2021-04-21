/**
 * 
 */
package covidtracker;

import student.TestCase;

/**
 * @author Carly Daffan
 *
 */
public class StateTest extends TestCase {
    private State VA;
    private State GA;
    private State NC;
    private Race race1;
    private Race race2;
    private Race race3;
    private Race race4;
    private Race race5;
    
    public void setUp() {
        race1 = new Race("White", "70", "10");
        race2 = new Race("Black", "60", "30");
        race3 = new Race("Latin", "100", "30");
        race4 = new Race("Asian", "70", "10");
        race5 = new Race("Other", "60", "10");
        VA = new State("Virginia",race1,race2,race3,race4,race5);
        GA = new State("Georgia",race3,race5,race4,race1,race2);
        NC = new State("North Carolina",race5,race4,race3,race3,race1);
    }
    
    public void testGetName() {
        assertEquals(VA.getName(), "Virginia");
        assertFalse(GA.getName().equals("Virginia"));
    }
    
    public void testEquals() {
        assertFalse(GA.equals(null));
        Object b = new Object();
        assertFalse(NC.equals(b));
        assertTrue(VA.equals(VA));
    }
}
