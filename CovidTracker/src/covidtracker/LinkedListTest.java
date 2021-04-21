package covidtracker;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * Tests methods in LinkedList and the inner Node class
 * @author Alip Arslan
 * @version 04.18.2021
 *
 */
public class LinkedListTest extends TestCase {
    
    // Fields ..........................................
    
    private LinkedList<String> list;
    
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
        assertEquals("A",list.get(0));
        assertEquals("B",list.get(1));
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
        
        LinkedList<String> list2 = new LinkedList<String>();
        list2.add("A");
        list2.add("B");
        assertFalse(list.equals(list2));
        list.add("A");
        list.add("B");
        assertTrue(list.equals(list2));
        
        list.add("B");
        list.add("C");
        list.add("D");
        list2.add("B");
        list2.add("C");
        list2.add("E");
        assertFalse(list.equals(list2));
        assertFalse(list2.equals(list));
    }
    
    /**
     * Tests iterator()
     */
    public void testIterator() {
        list.add("A");
        list.add("B");
        list.add("C");
        Iterator<String> iterator = list.iterator();
        assertEquals("A",iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B",iterator.next());
        assertEquals("C",iterator.next());
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
    
}
