package covidtracker;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a linked list using nodes
 * 
 * @author Alip Arslan
 * @version 04.17.2021
 *
 * @param <T>
 *            Object type the linked list will store
 */
public class LinkedList<T> {

    // Fields ........................................

    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Constructor ...................................

    /**
     * Creates an empty linked list
     */
    public LinkedList() {
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.setNext(tail);
        size = 0;
    }

    // Methods .......................................


    /**
     * Clears the list by making the head reference null
     * and resetting the size to 0
     */
    public void clear() {
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.setNext(tail);
        size = 0;
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
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there no node at the given index
     */
    public T get(int index) {
        return getNodeAtIndex(index).data();
    }


    /**
     * gets the node at that index
     * 
     * @param index
     * @return node at index
     */
    private Node<T> getNodeAtIndex(int index) {
        if (index < 0 || this.size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<T> current = head.next();
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current;
    }


    /**
     * Adds a node with given data to the end of the list
     * 
     * @param data
     *            data to be added
     * 
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }

        Node<T> newNode = new Node<T>(data);
        Node<T> beforeTail = head;
        while (beforeTail.next() != tail) {
            beforeTail = beforeTail.next();
        }
        beforeTail.setNext(newNode);
        newNode.setNext(tail);
        size++;

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
     * *In reverse order (i.e. newest items will be first)
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
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<T> iterator() {
        return new ListIterator<T>();
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
         * Constructor no next
         * 
         * @param data
         */
        public Node(T data) {
            this(data, null);
        }


        /**
         * Constructor with next
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
         * Return data
         * 
         * @return data
         */
        public T data() {
            return this.data;
        }


        /**
         * Return next node
         * 
         * @return next node
         */
        public Node<T> next() {
            return this.next;
        }


        /**
         * Set next node
         * 
         * @param nextNode
         */
        public void setNext(Node<T> nextNode) {
            this.next = nextNode;
        }

    }


    /**
     * Class for iterating through the list
     * 
     * @author mattwilson
     *
     * @param <T>
     */
    private class ListIterator<E> implements Iterator<T> {
        private Node<T> iterator;

        /**
         * Creates a new DLListIterator
         */
        public ListIterator() {
            iterator = head;

        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return (iterator.next() != null);
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public T next() {
            if (iterator.next() == null) {
                throw new NoSuchElementException();
            }
            else {
                iterator = iterator.next();
                return iterator.data();
            }

        }

    }

}
