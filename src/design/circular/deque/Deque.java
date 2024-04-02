package design.circular.deque;

import design.circular.queue.Queue;

public interface Deque extends Queue {

    /**
     * Adds an element to the end of the dequeue.
     *
     * @param element the element to add
     */
    void addLast(int element);

    /**
     * Removes and returns the last element of the dequeue.
     *
     * @return the last element of the dequeue, or null if the dequeue is empty
     */
    int removeLast();
}

