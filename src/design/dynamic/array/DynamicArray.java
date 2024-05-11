/**
 * 
 */
package design.dynamic.array;

import java.util.Arrays;

/**
 * Supports only type integers 32-bit
 */
public class DynamicArray {

    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer.
     */
    private transient int[] array;
    
    /**
     * The size of the Array (the number of elements it contains).
     *
     */
    private int size;
    
    /**
     * the capacity of the array (array.length)
     */
    private int capacity;
    
    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    
    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param  initialCapacity  the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public DynamicArray(int initialCapacity) {
        if (initialCapacity < 0){
            throw new IllegalArgumentException("Illegal Capacity: "+initialCapacity);
        }
        size = 0;
        this.capacity = initialCapacity;
        this.array = new int[initialCapacity];
    }
    
    public DynamicArray(){
        this(10);
    }
    
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException 
     */
    public int get(int index) {
        if(index < 0 || index >= capacity){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        return array[index];
    }
    
    
    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException
     */
    public int set(int index, int n) {
        if(index < 0 || index >= capacity){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        int oldValue = array[index];
        array[index] = n;
        return oldValue;
    }
    
    
    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @return <tt>true</tt> if element got added
     */
    public boolean add(int n) {
        resizeIfNeeded();
        array[size++] = n;
        return true;
    }
    
    
    public boolean add(int index, int n){
        return false;
    }

    public int popback() {
        int popped = array[size-1];
        --size;
        return popped;
    }

    
    private void resizeIfNeeded() {
        if(size == capacity){
            capacity = capacity * 2;
            if(capacity >= DynamicArray.MAX_ARRAY_SIZE){
                capacity = Integer.MAX_VALUE;
            }
            array = Arrays.copyOf(array, capacity);
        }
    }
    
    
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
    
    
    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    
    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    public void clear() {
        for (int i = 0; i < size; i++)
            array[i] = 0;

        size = 0;
    }
}

