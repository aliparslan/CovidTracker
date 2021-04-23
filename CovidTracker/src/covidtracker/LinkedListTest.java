package covidtracker;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * Tests methods in LinkedList and the inner Node class
 * 
 * @author Alip Arslan
 * @version 04.23.2021
 *
 */
public class LinkedListTest extends TestCase {

    // Fields ..........................................

    private LinkedList<String> list;
    private LinkedList<Race> list2;

    // Constructor .....................................

    /**
     * Empty constructor
     */
    public LinkedListTest() {
        // Intentionally left empty
    }

    // Methods .........................................


    /**
     * Code to be run before every test
     */
    public void setUp() {
        list = new LinkedList<String>();
        list2 = new LinkedList<Race>();
    }


    /**
     * tests isEmpty()
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }


    /**
     * tests size()
     */
    public void testSize() {
        assertEquals(0, list.size());

        list.add("A");
        assertEquals(1, list.size());

        list.add("A");
        list.add("A");
        list.add("A");
        list.add("A");
        assertEquals(5, list.size());
    }


    /**
     * Test get()
     */
    public void testGet() {
        list.add("A");
        list.add("B");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }
    
    /**
     * tests get() when expecting an exception
     */
    public void testGetException() {
        Exception e = null;
        try {
            list.get(-1);
        }
        catch (Exception exception) {
            e = exception;
            
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * tests add() when expecting exception
     */
    public void testAddException() {
        Exception e = null;
        try {
            list.add(null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * tests add()
     */
    public void testAdd() {
        list.add("A");
        assertEquals(1, list.size());

        list.add("A");
        list.add("A");
        list.add("A");
        list.add("A");
        list.add("A");
        list.add("A");
        list.add("A");
        list.add("A");
        list.add("A");
        assertEquals(10, list.size());
    }


    /**
     * tests clear()
     */
    public void testClear() {
        list.add("A");
        list.add("A");
        list.add("A");
        list.add("A");
        assertEquals(4, list.size());

        list.clear();
        assertEquals(0, list.size());
    }


    /**
     * tests toString()
     */
    public void testToString() {
        assertEquals("{}", list.toString());

        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("{A, B, C}", list.toString());
    }


    /**
     * tests equals()
     */
    public void testEquals() {
        assertTrue(list.equals(list));

        Object n = null;
        assertFalse(list.equals(n));

        Object o = new Object();
        assertFalse(list.equals(o));

        LinkedList<String> list3 = new LinkedList<String>();
        list3.add("A");
        list3.add("B");
        assertFalse(list.equals(list3));
        list.add("A");
        list.add("B");
        assertTrue(list.equals(list3));

        list.add("B");
        list.add("C");
        list.add("D");
        list3.add("B");
        list3.add("C");
        list3.add("E");
        assertFalse(list.equals(list3));
        assertFalse(list3.equals(list));
    }


    /**
     * Tests iterator()
     */
    public void testIterator() {
        list.add("A");
        list.add("B");
        list.add("C");
        Iterator<String> iterator = list.iterator();
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
        Exception e = null;
        try {
            iterator.next();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof NoSuchElementException);

    }
    
    
    


    /**
     * Tests sort()
     */
    public void testSort() {
        Race whiteDC = new Race("White", "70678", "1924");
        Race blackDC = new Race("Black", "179563", "13365");
        Race latinDC = new Race("LatinX", "97118", "2269");
        Race asianDC = new Race("Asian", "5407", "254");
        Race otherDC = new Race("Other", "108784", "170");
        list2.add(whiteDC);
        list2.add(blackDC);
        list2.add(latinDC);
        list2.add(asianDC);
        list2.add(otherDC);
        list2.sort(new CompareAlpha());
        assertEquals(asianDC, list2.get(0));
        assertEquals(blackDC, list2.get(1));
        assertEquals(latinDC, list2.get(2));
        assertEquals(otherDC, list2.get(3));
        assertEquals(whiteDC, list2.get(4));

        list2.sort(new CompareCFR());
        assertEquals(blackDC, list2.get(0));
        assertEquals(asianDC, list2.get(1));
        assertEquals(whiteDC, list2.get(2));
        assertEquals(latinDC, list2.get(3));
        assertEquals(otherDC, list2.get(4));
        
        LinkedList<Race> list3 = new LinkedList<Race>();
        list3.sort(new CompareAlpha());
        // just trying this for test coverage

    }

}
