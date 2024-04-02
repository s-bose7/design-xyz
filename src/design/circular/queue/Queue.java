package design.circular.queue;

public interface Queue {
	
	public static class ListNode {
        public int val;
		public ListNode prev, next;
        
        public ListNode(int val){
            this.val = val;
            this.prev = this.next = null;
        }
    }
	
	/**
     * Adds an element to the front of the queue.
     *
     * @param element the element to add
     */
    void addFirst(int element);

    /**
     * Removes and returns the first element of the queue.
     *
     * @return the first element of the queue, or null if the queue is empty
     */
    int removeFirst();

    /**
     * Retrieves, but does not remove, the first element of the queue.
     *
     * @return the first element of the queue, or null if the queue is empty
     */
    int getFirst();

    /**
     * Retrieves, but does not remove, the last element of the queue.
     *
     * @return the last element of the queue, or null if the queue is empty
     */
    int getLast();

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    int size();

    /**
     * Checks if the dequeue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();
    /**
     * Checks if the queue is full.
     *
     * @return true if the queue is full, false otherwise
     */
    boolean isFull();
    /**
     * Clears all elements from the queue.
     */
    void clear();
}
