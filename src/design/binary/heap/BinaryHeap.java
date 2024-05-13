package design.binary.heap;

/**
 * This class represents a Binary Heap data structure.
 * A Binary Heap is a complete binary tree where the value in each internal node is
 * greater than or equal to (or less than or equal to) the values in the children of that node.
 */
public class BinaryHeap {
	
	/**
	 * Primitive array as backing datastructures for most simplicity
	 * @anode: i
	 * @aleft: 2i+1
	 * @right: 2i+2
	 * 
	 * @parent: (i-1)/2
	 */
	private int[] heap;
	
	/** 
	 * Size of the current heap (number of elements present) 
	 */
	private int size;
	
	/**
	 * Maximum capacity of the heap, as we're using fixed sized array
	 */
	private static int MAX_CAPACITY;

    /**
     * Constructs a Binary Heap from the given array.
     *
     * @param arr the array to build the Binary Heap from
     */
    public BinaryHeap(int[] arr) {
       this.heap = arr;
       this.size = arr.length;
       BinaryHeap.MAX_CAPACITY = size;
       heapify(heap);
    }

    /**
     * Heapifies the Binary Heap.
     * Rearranges the elements in the heap to maintain the heap properties.
     * @Time O(nlogn)
    */
    private void heapify(int arr[]) { 
        for(int i=size-1; i>=0; i--) {
        	shiftDownwards(i);
        }
    }

	/**
	 * @return the size (number of elements present)
	*/
	public int getSize() {
		return size;
	}

	/**
     * Shifts an element upwards in the Binary Heap to maintain the heap properties.
     * @Time O(logn)
    */
    private void shiftUpwards(int index) {
    	int parent = (index-1)/2;
    	while(index >= 0 && heap[index] < heap[parent]) {
    		heap[parent] = heap[index] + heap[parent] - (heap[index] = heap[parent]);
    		index = parent;
    		parent = (index-1)/2;
    	}
    }

    /**
     * Shifts an element downwards in the Binary Heap to maintain the heap properties.
     * @Time O(logn)
    */
    private void shiftDownwards(int index) {
    	int left = 2*index + 1;
    	int right = left + 1;
    	while(
		(left < size && heap[left] < heap[index]) ||
		(right < size && heap[right] < heap[index])) {
    		
    		int smallest = (heap[left] < heap[right] ? left : right);
    		heap[smallest] = heap[index] + heap[smallest] - (heap[index] = heap[smallest]);
    		index = smallest;
    		left = 2*index + 1;
    		right = left + 1;
    	}
       
    }

    /**
     * Adds a new value to the Binary Heap, if there's space available
     *
     * @param val the value to be added
     * @Time O(logn)
    */
    public void add(int val) {
    	if(size == BinaryHeap.MAX_CAPACITY) {
    		return;
    	}
    	heap[size++] = val;
    	shiftUpwards(size-1);
    }

    /**
     * Returns the minimum value in the Binary Heap.
     *
     * @return the minimum value, or -1 if the heap is empty
     * @Time O(1)
    */
    public int getMin() {
        return heap[0];
    }

    /**
     * Returns the maximum value in the Binary Heap.
     *
     * @return the maximum value
     * @Time O(1)
     * @deprecated it's a min heap implementation
    */
    public int getMax() {
        return heap[size-1];
    }
    
    /**
     * Return and remvoe the minimum value in the Binary Heap.
     *
     * @return the minimum value, -1 if the heap is empty
     * @Time O(logn)
    */
    public int removeMin() {
    	if(size == 0) {
    		return -1;
    	}
    	int min = getMin();
    	heap[0] = heap[size-1];
    	--size;
    	shiftDownwards(0);
    	return min;
    }

    /**
     * Sets the value at the specified index in the Binary Heap.
     *
     * @param index the index at which the value should be set
     * @param val   the new value to be set
     * @return true if the operation was successful
     * @throws IndexOutOfBoundException
     * @Time O(logn)
    */
    public boolean set(int index, int val) {
    	if(index < 0 || index >= size) {
    		throw new IndexOutOfBoundsException("index "+index+" is out of bound for size "+size);
    	}
    	int old = heap[index];
    	heap[index] = val;
    	if(heap[index] < old) {
    		shiftUpwards(index);
    	}else {
    		shiftDownwards(index);
    	}
        
    	return true;
    }
    
    /**
     * Sets the value at the specified index in the Binary Heap.
     *
     * @param index the index at which the value should be set
     * @param val   the new value to be set
     * @return true if the operation was successful, false otherwise
     * @Time O(logn)
    */
    public boolean setInSilent(int index, int val) {
    	if(index < 0 || index >= size) {
    		return false;
    	}    	
        return set(index, val);
    }
    
    /**
     * Replace the value specified from the Binary Heap.
     *
     * @param oldVal the value should be replace
     * @param newVal the new value to be set
     * @return true if the operation was successful, false otherwise
     * @Time O(n)
    */
    public boolean replace(int oldVal, int newVal) {
    	int index = -1;
    	for(int i=0; i<size; i++) {
    		if(heap[i] == oldVal) {
    			index = i;
    			break;
    		}
    	}
    	if(index < 0) {
        	return false;
    	}
    	return setInSilent(index, newVal);
    }
}