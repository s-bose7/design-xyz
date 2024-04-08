package min.stack.test;

import static org.junit.Assert.*;

import design.min.stack.MinStack;

import org.junit.Test;

public class MinStackTest {

	@Test
	public void pushStack() {
		MinStack minStack = new MinStack();
		minStack.push(1);
		assertEquals(1, minStack.peek());
		assertEquals(1, minStack.getMin());
	}
	
	@Test
	public void popStack() {
		MinStack minStack = new MinStack();
		minStack.push(1);
		minStack.pop();
		assertEquals(-1, minStack.peek());
	}
	
	@Test
	public void peekStack() {
		MinStack minStack = new MinStack();
		minStack.push(1);
		minStack.push(3);
		minStack.push(5);
		assertEquals(5, minStack.peek());
	}
	
	@Test
	public void getMin() {
		MinStack minStack = new MinStack();
		minStack.push(1);
		assertEquals(1, minStack.getMin());
		minStack.push(2);
		assertEquals(1, minStack.getMin());
		minStack.push(3);
		assertEquals(1, minStack.getMin());
		minStack.push(5);
		assertEquals(1, minStack.getMin());
		minStack.push(0);
		assertEquals(0, minStack.getMin());
	}

}
