package circular.queue.test;

import static org.junit.Assert.*;

import org.junit.Test;

import design.circular.queue.CircularQueue;
import design.circular.queue.Queue;

public class CircularQueueTest {

	@Test
	public void addLast() {
		Queue cQueue = new CircularQueue(2);
		cQueue.addLast(0);
		assertEquals(0, cQueue.getLast());
		cQueue.addLast(1);
		assertEquals(1, cQueue.getLast());
		cQueue.addLast(2);
		assertEquals(1, cQueue.getLast());
	}
	
	@Test
	public void removeFirst() {
		Queue cQueue = new CircularQueue(2);
		cQueue.addLast(0);
		cQueue.addLast(5);
		assertEquals(0, cQueue.removeFirst());
		assertEquals(5, cQueue.removeFirst());
	}
	
	@Test
	public void getFirst() {
		Queue cQueue = new CircularQueue(2);
		cQueue.addLast(0);
		cQueue.addLast(5);
		assertEquals(0, cQueue.getFirst());
		cQueue.removeFirst();
		assertEquals(5, cQueue.getFirst());
	}
	
	@Test
	public void getLast() {
		Queue cQueue = new CircularQueue(2);
		cQueue.addLast(0);
		cQueue.addLast(5);
		assertEquals(5, cQueue.getLast());
		cQueue.addLast(2);
		assertEquals(5, cQueue.getLast());
	}
	
	@Test
	public void isEmpty() {
		Queue cQueue = new CircularQueue(5);
		assertTrue(cQueue.isEmpty());
		cQueue.addLast(0);
		cQueue.addLast(1);
		cQueue.addLast(2);
		cQueue.addLast(3);
		cQueue.addLast(4);
		assertFalse(cQueue.isEmpty());
	}
	
	@Test
	public void isFull() {
		Queue cQueue = new CircularQueue(5);
		assertFalse(cQueue.isFull());
		cQueue.addLast(0);
		cQueue.addLast(1);
		cQueue.addLast(2);
		cQueue.addLast(3);
		cQueue.addLast(4);
		assertTrue(cQueue.isFull());
	}
	
	@Test
	public void clear() {
		Queue cQueue = new CircularQueue(5);
		cQueue.addLast(0);
		cQueue.addLast(1);
		assertEquals(2, cQueue.size());
		cQueue.clear();
		assertEquals(0, cQueue.size());
	}

}
