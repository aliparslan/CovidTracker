package covidtracker;

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
     * tests peek() when expecting exception
     */
    public void peekException() {
        Exception e = null;
        try {
            list.peek();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof NullPointerException);
    }
    
    /**
     * tests peek()
     */
    public void testPeek() {
        list.add("A");
        assertEquals("A", list.peek());
        
        list.add("B");
        list.add("C");
        list.add("D");
        assertEquals("D", list.peek());
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
     * tests pop() when expecting exception
     */
    public void testPopException() {
        Exception e = null;
        try {
            list.pop();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof NullPointerException);
    }
    
    /**
     * tests pop()
     */
    public void testPop() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("C", list.pop());
        assertEquals(2, list.size());
        assertEquals("B", list.pop());
        assertEquals(1, list.size());
        assertEquals("A", list.pop());
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
        assertEquals("{C, B, A}", list.toString());
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
        
        LinkedList<String> list2 = new LinkedList<String>("A");
        assertFalse(list.equals(list2));
        list.add("A");
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
    
    
    
}
