package covidtracker;

import java.util.Iterator;

/**
 * 
 * @author aliparslan
 * @version 04.17.2021
 *
 * @param <T>
 */
public class LinkedList<T> implements Iterator {
    
    // Fields ........................................
    
    private Node<T> head;
    private Node<T> tail; // not sure if we need this
    private int size;
    
    
    // Constructor ...................................
    
    /**
     * Creates an empty linked list
     */
    public LinkedList() {
        head = null;
        size = 0;
    }
    
    /**
     * Creates a linked list with data in the
     * head node
     */
    public LinkedList(T data) {
        head.data = data;
        size = 1;
    }
    
    
    // Methods .......................................
    
    /**
     * 
     */
    public void clear() {
        if (head != null) {
            head.setNext(null);
            head = null;
            size = 0;
        }
    }
    
    /**
     * 
     * @return
     */
    public int size() {
        return this.size;
    }
    
    /**
     * 
     * @return
     */
    public T peek() {
        
    }
    
    /**
     * 
     * @param data
     * @return
     */
    public boolean add(T data) {
        
    }
    
    /**
     * 
     * @return
     */
    public T remove() {
        
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        
    }
    
    /**
     * 
     * @return
     */
    @Override
    public Object[] toArray() {
        
    }
    
    /**
     * 
     */
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        // iterator method
        return false;
    }
    
    /**
     * 
     */
    @Override
    public Object next() {
        // TODO Auto-generated method stub
        // iterator method
        return null;
    }
    
    
    /**
     * 
     * @author aliparslan
     * @version 04.17.2021
     *
     * @param <T>
     */
    public static class Node<T> {
        
        // Fields ....................................
        
        private T data;
        private Node<T> head;
        private Node<T> next;
        
        // Constructor ...............................
        
        /**
         * 
         * @param data
         */
        public Node(T data) {
            this.data = data;
        }
        
        /**
         * 
         * @param data
         * @param nextNode
         */
        public Node(T data, Node<T> nextNode) {
            this.data = data;
            this.next = nextNode;
        }
        
        // Methods ...................................
        
        
        /**
         * 
         * @return
         */
        public T data() {
            return this.data;
        }
        
        /**
         * 
         * @return
         */
        public Node<T> next() {
            return this.next;
        }
        
        /**
         * 
         * @param nextNode
         */
        public void setNext(Node<T> nextNode) {
            this.next = nextNode;
        }
        
        /**
         * 
         * @param node
         * @return
         */
        public int compareTo(Node<T> node) {
            // TODO
            return -1;
        }
        
        
        
    }
    
}
