package covidtracker;

import java.util.Iterator;

/**
 * Implementation of a linked list using nodes
 * 
 * @author Alip Arslan
 * @version 04.17.2021
 *
 * @param <T>
 *            Object type the linked list will store
 */
public class LinkedList<T> implements Iterator {

    // Fields ........................................

    private Node<T> head;
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
     * Clears the list by making the head reference null
     * and resetting the size to 0
     */
    public void clear() {
        if (head != null) {
            head.setNext(null);
            head = null;
            size = 0;
        }
    }


    /**
     * Checks if the list is empty
     * 
     * @return if size is 0
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }


    /**
     * Returns the number of elements in the linked list
     * 
     * @return number of elements in the linked list
     */
    public int size() {
        return this.size;
    }


    /**
     * Looks at the item at the front of the list
     * 
     * @return the contents of the head node
     */
    public T peek() {
        return head.data();
    }


    /**
     * Adds a node with given data to the top of the list
     * 
     * @param data
     *            data to be added
     * 
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }

        if (this.isEmpty()) {
            head = new Node<T>(data);
            size++;
        }

        else {
            Node<T> curr = new Node<T>(data);
            curr.setNext(head);
            head = curr;
            size++;
        }

    }


    /**
     * Removes most recently added object
     * (i.e. the item at the top)
     * 
     * @return the data of the removed object
     */
    public T pop() {
        if (this.isEmpty()) {
            throw new NullPointerException("List is empty");
        }
        T remove = head.data();
        head = head.next();
        size--;
        return remove;
    }


    /**
     * String representation of a LinkedList
     * Example: "{Apples, Bananas, Oranges}"
     * 
     * @return a string representing the list
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{");
        Node<T> curr = head;
        while (curr != null) {
            s.append(curr.data());
            curr = curr.next();
            if (curr != null) {
                s.append(", ");
            }
        }
        s.append("}");
        return s.toString();
    }


    /**
     * Returns true if both lists have the same contents
     * in the same order
     * 
     * @return if the two lists are equal
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (this.getClass() == o.getClass()) {
            LinkedList<T> other = (LinkedList<T>)o;
            if (other.size() == this.size()) {
                Node<T> curr = head;
                Node<T> otherCurr = other.head;
                while (curr != null) {
                    if (!curr.data().equals(otherCurr.data())) {
                        return false;
                    }
                    curr = curr.next();
                    otherCurr = otherCurr.next();
                }
                return true;
            }
        }

        return false;
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
     * Represents node in a linked list. Stores data and a
     * reference to the next node
     * 
     * @author Alip Arslan
     * @version 04.17.2021
     *
     * @param <T>
     *            Object type the node will store
     */
    public static class Node<T> {

        // Fields ....................................

        private T data;
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

    }

}
