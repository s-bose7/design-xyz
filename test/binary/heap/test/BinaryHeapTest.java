package binary.heap.test;

import static org.junit.Assert.*;

import org.junit.Test;

import design.binary.heap.BinaryHeap;

public class BinaryHeapTest {

	@Test
	public void binaryHeap() {
		BinaryHeap heap = new BinaryHeap(new int[] {10, 2, 5, 4, 7, 8, 1, 3, 6, 9});
		assertEquals(1, heap.getMin());
		assertEquals(false, heap.replace(13, 12));
		assertEquals(true, heap.replace(10, 12));
		assertEquals(1, heap.removeMin());
		assertEquals(18, Math.multiplyExact(heap.getSize(), 2));
		heap.add(-1);
		assertEquals(-1, heap.getMin());
		heap.add(10);
		assertEquals(20, Math.multiplyExact(heap.getSize(), 2));
		
	}
	
	@Test
	public void heapSort() {
		int[] unsortedArray = new int[] {10, 2, 5, 4, 7, 8, 1, 3, 6, 9};
		BinaryHeap heap = new BinaryHeap(unsortedArray);
		int[] sortedArray = new int[10];
		for(int i=0; i<10; i++) {
			sortedArray[i] = heap.removeMin();
		}
		assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, sortedArray);
	}
	
	@Test
	public void priorityQueue() {
		
	}

}
