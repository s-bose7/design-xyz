package design.circular.deque;

public interface Deque<E> {
    /**
     * Adds an element to the front of the dequeue.
     *
     * @param element the element to add
     */
    void addFirst(E element);

    /**
     * Adds an element to the end of the dequeue.
     *
     * @param element the element to add
     */
    void addLast(E element);

    /**
     * Removes and returns the first element of the dequeue.
     *
     * @return the first element of the dequeue, or null if the dequeue is empty
     */
    E removeFirst();

    /**
     * Removes and returns the last element of the dequeue.
     *
     * @return the last element of the dequeue, or null if the dequeue is empty
     */
    E removeLast();

    /**
     * Retrieves, but does not remove, the first element of the dequeue.
     *
     * @return the first element of the dequeue, or null if the dequeue is empty
     */
    E getFirst();

    /**
     * Retrieves, but does not remove, the last element of the dequeue.
     *
     * @return the last element of the dequeue, or null if the dequeue is empty
     */
    E getLast();

    /**
     * Returns the number of elements in the dequeue.
     *
     * @return the number of elements in the dequeue
     */
    int size();

    /**
     * Checks if the dequeue is empty.
     *
     * @return true if the dequeue is empty, false otherwise
     */
    boolean isEmpty();
    /**
     * Checks if the dequeue is full.
     *
     * @return true if the dequeue is full, false otherwise
     */
    boolean isFull();
    /**
     * Clears all elements from the dequeue.
     */
    void clear();
}

