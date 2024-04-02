package design.circular.queue;


public class CircularQueue implements Queue {
	
	public ListNode front, rear;
	public int size;
	public final int MAX_SIZE;
	
	public CircularQueue(int n){
		this.size = 0;
		this.MAX_SIZE = n;
		
		this.front = this.rear = null;
	}

	@Override
	public void addFirst(int element) {
		// TODO Auto-generated method stub
		if(isFull()){
            return;
        }
		ListNode node = new ListNode(element);
		if(front == null) {
			front = rear = node;
		}else {
			rear.next = node;
			node.prev = rear;
			rear = node;
		}
		++size;
	}

	@Override
	public int removeFirst() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return -1;
		}
		
		ListNode node = front;
		int val = node.val;
		front = front.next;
		node = null;
		
		return val;
	}

	@Override
	public int getFirst() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return -1;
		}
		return front.val;
	}

	@Override
	public int getLast() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return -1;
		}
		return rear.val;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return size == MAX_SIZE;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		front = rear = null;
	}

}
