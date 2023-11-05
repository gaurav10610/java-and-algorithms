package stack;

import java.util.Stack;

/**
 * 
 * Design a stack that supports all the below mentioned operations with expectd
 * time complexity
 * 
 * 1. push() - O(1)
 * 
 * 2. pop() - O(1)
 * 
 * 3. isEmpty() - O(1)
 * 
 * 4. isFull() - O(1)
 * 
 * 5. getMin() - O(1)
 * 
 * NOTE - To implement above stack, you should only use standard Stack data
 * structure and no other data structure like arrays, list, . etc.
 *
 */
public class SpecialStackWithGetMin {

	public static void main(String[] args) {
		SpecialStack stack = new SpecialStack(10);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack.getMinimum());
		stack.push(5);
		System.out.println(stack.getMinimum());

	}

}

class SpecialStack {

	// this stack will be used to store actual values
	private Stack<Integer> actualStack;

	// this stack will be used to store min value on top
	private Stack<Integer> auxiliaryStack;

	private int capacity;
	private int size;

	public SpecialStack(int capacity) {
		this.capacity = capacity;
		this.actualStack = new Stack<>();
		this.auxiliaryStack = new Stack<>();
	}

	/**
	 * 
	 * pushes an element in stack and returns true else return false if stack is
	 * already full
	 */
	public boolean push(Integer element) {
		if (isFull())
			return false;

		size++;
		actualStack.push(element);
		if (!auxiliaryStack.isEmpty() && auxiliaryStack.peek().intValue() < element.intValue()) {
			auxiliaryStack.push(auxiliaryStack.peek());
		} else {
			auxiliaryStack.push(element);
		}
		return true;
	}

	/**
	 * 
	 * removes element from top of the stack and return it else return null is stack
	 * is empty
	 */
	public Integer pop() {
		if (isEmpty())
			return null;

		size--;
		auxiliaryStack.pop();
		return actualStack.pop();
	}

	/**
	 * 
	 * returns minimum value from the stack else returns null if stack is empty
	 */
	public Integer getMinimum() {
		if (isEmpty())
			return null;
		return auxiliaryStack.peek();
	}

	/**
	 * 
	 * returns boolean specifying whether stack is full or not
	 */
	public boolean isFull() {
		return size == capacity;
	}

	/**
	 * 
	 * returs boolean specifying whether stack is empty or not
	 */
	public boolean isEmpty() {
		return size == 0;
	}
}
