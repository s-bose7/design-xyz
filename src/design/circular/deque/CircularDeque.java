package design.circular.deque;

import design.circular.queue.CircularQueue;

public class CircularDeque extends CircularQueue implements Deque { 

	public CircularDeque(int n) {
		// TODO Auto-generated constructor stub
		super(n);
	}

	@Override
	public void addFirst(int element) {
		// TODO Auto-generated method stub
		if(isFull()){
            return;
        }
		ListNode node = new ListNode(element);
		if(isEmpty()) {
			front = rear = node;
		}else {
			node.next = front;
			front.prev = node;
			front = node;
		}
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
