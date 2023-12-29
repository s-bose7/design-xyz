package designMinStack;

public class MinStackController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minStack = new MinStack();
		System.out.println("Current size of the stack "+minStack.currentSize());
		minStack.pop(); // Stack is Empty
		System.out.println(minStack.getMin()); // Stack is Empty -1
		minStack.push(5); 
		System.out.println(minStack.getMin()); // 5
		minStack.push(6);
		System.out.println(minStack.getMin()); // 5
		minStack.push(4);
		System.out.println(minStack.getMin()); // 4
		minStack.push(1);
		System.out.println(minStack.getMin()); // 1
		minStack.push(6);
		System.out.println(minStack.getMin()); // 1
		minStack.push(22);
		System.out.println(minStack.getMin()); // 1
		minStack.push(0);
		System.out.println(minStack.getMin()); // 0
		minStack.push(4);
		System.out.println(minStack.getMin()); // 0
		minStack.pop();
		System.out.println(minStack.getMin()); // 0
		minStack.pop();
		System.out.println(minStack.getMin()); // 1
		minStack.pop();
		System.out.println(minStack.getMin()); // 1
		minStack.pop();
		System.out.println(minStack.getMin()); // 1
		minStack.pop();
		System.out.println(minStack.getMin()); // 4
		minStack.pop();
		System.out.println(minStack.getMin()); // 5
	}

}
