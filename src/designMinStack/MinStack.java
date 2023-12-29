package designMinStack;

public class MinStack {
	private StackCell top;
	private long size;
	
	public MinStack() {
		this.top = null;
		this.size = 0;
	}
	
	public void push(int value) {
		StackCell newStackCell = new StackCell(value);
		size++;
		if(top == null) {
			top = newStackCell;
			return;
		}
		top.next = newStackCell;
		newStackCell.prev = top;
		top = newStackCell;
		/* Update the minimum element in the stack if required */
		if(top.value > top.prev.minElementAtThisTime) {
			top.minElementAtThisTime = top.prev.minElementAtThisTime;
		}
	}
	
	public void pop() {
		if(top==null) {
			System.out.println("Stack is Empty");
			return;
		}
		size--;
		StackCell currTop = top;
		top = top.prev;
		// Making currTop eligible for garbage collection
		currTop.prev.next = currTop.prev = null;
	}
	
	public long currentSize() {
		// return the current size of the stack
		return this.size;
	}
	
	public int getMin() {
		if(top==null) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return top.minElementAtThisTime;
		
	}
}
