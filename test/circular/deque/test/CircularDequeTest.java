package circular.deque.test;

import static org.junit.Assert.*;

import org.junit.Test;

import design.circular.deque.CircularDeque;

public class CircularDequeTest {

	@Test
	public void addFirst() {
	    CircularDeque deque = new CircularDeque(5);
	    deque.addFirst(0);
	    assertEquals(0, deque.getFirst());
	    deque.addFirst(1);
	    assertEquals(1, deque.getFirst());
	    deque.addFirst(2);
	    assertEquals(2, deque.getFirst());
	    deque.addFirst(3);
	    assertEquals(3, deque.getFirst());
	    deque.addFirst(4);
	    assertEquals(4, deque.getFirst());
	    deque.addFirst(5);
	    assertEquals(4, deque.getFirst());
	}

	
	@Test
	public void removeLast() {
		CircularDeque deque = new CircularDeque(5);
		
		deque.addFirst(0);
		deque.addLast(1);
		deque.addFirst(2);
		deque.addLast(3);
		// 2 - 0 - 1 - 3
		assertEquals(3, deque.removeLast());
		assertEquals(1, deque.removeLast());
		assertEquals(0, deque.removeLast());
		assertEquals(2, deque.removeLast());
	}

}
