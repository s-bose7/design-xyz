package design.min.stack;

public class MinStack {
	
	private static class Node {
		int value, minValue;
		Node nextNode;
		
		public Node(int value) {
			this.value = value;
			this.minValue = Integer.MAX_VALUE;
			this.nextNode = null;
		}
	}
	
	private Node peekNode;
	private int minValue;
	
	public MinStack() {
		this.peekNode = null;
		this.minValue = Integer.MAX_VALUE;
	}
	
	
	public void push(int value) {
		Node nodeToPush = new Node(value);
		if(value < minValue) {
			minValue = value;
		}
		nodeToPush.minValue = minValue;
		if(peekNode == null) {
			peekNode = nodeToPush;
		}else {
			nodeToPush.nextNode = peekNode;
			peekNode = nodeToPush;
		}
	}
	
	public void pop() {
		if(peekNode != null) {
			Node topNode = peekNode;
			peekNode = peekNode.nextNode;
			topNode.nextNode = null;
		}
		
		if (peekNode == null) {
			minValue = Integer.MAX_VALUE;
		}
	}
	
	public int peek() {
		if(peekNode == null) {
			return -1;
		}
		return peekNode.value;
	}
	
	public int getMin() {
		if(peekNode == null) {
			return -1;
		}
		return peekNode.minValue;
	}
}
