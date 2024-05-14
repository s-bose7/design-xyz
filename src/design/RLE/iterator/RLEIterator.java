package design.RLE.iterator;


class RLEIterator {
	/**
     * The encoded RLE array.
     */
    private final int[] encoded;

    /**
     * Index of the current element in the encoded array.
     */
    private int currentIndex;
    private int capacity;
	/**
     * Initializes the RLEIterator object with the encoded array.
     * 
     * @param encoded The RLE encoded array.
     */
    public RLEIterator(int[] encoding) {
        this.capacity = encoding.length;
        if(capacity % 2 == 1) {
        	throw new IllegalArgumentException("encoding length must be even");
        }
        this.encoded = encoding;
        this.currentIndex = 0;
    }
    
    /**
     * Returns the next element exhausted from the RLE array for the specified number (n).
     * 
     * This method exhausts the next `n` elements from the encoded array and returns the 
     * last element exhausted. If there are no elements left to exhaust, it returns -1.
     * 
     * @param n The number of elements to exhaust.
     * @return The last element exhausted, or -1 if no elements remain.
     */
    public int next(int n) {
    	for(int i=0; i<n; i++) {
    		while(encoded[currentIndex] == 0) {
    			currentIndex += 2;
    			if(currentIndex >= capacity) {
    				return -1;
    			}
    		}
    		encoded[currentIndex] -= 1;
    	}
    	return encoded[currentIndex+1];
    }
}
