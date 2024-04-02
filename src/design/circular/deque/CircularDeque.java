package design.circular.deque;

import design.circular.queue.CircularQueue;

public class CircularDeque extends CircularQueue implements Deque { 

	public CircularDeque(int n) {
		// TODO Auto-generated constructor stub
		super(n);
	}

	@Override
	public void addLast(int element) {
		// TODO Auto-generated method stub
		if(isFull()) {
			return;
		}
		if(isEmpty()) {
			addFirst(element);
		}
		ListNode node = new ListNode(element);
		rear.next = node;
        node.prev = rear;
        rear = node;
        ++size;
	}

	@Override
	public int removeLast() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return -1;
		}
		ListNode node = rear;
		int val = node.val;
		rear = rear.prev;
		node = null;
		--size;
		return val;
	}
}
