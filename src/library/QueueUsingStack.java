package library;

import java.util.Stack;

/**
 * 
 * custom implementation of queue using stacks
 * 
 */
public class QueueUsingStack<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;
	private int size;

	public QueueUsingStack() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
		size = 0;
	}

	/**
	 * 
	 * adds an element in the queue
	 * 
	 */
	public void offer(T element) {
		size++;
		stack1.push(element);
	}

	/**
	 * 
	 * removes and returns the element from head of the queue else null if queue is
	 * empty
	 */
	public T poll() {

		// return null if queue is empty
		if (isEmpty())
			return null;

		if (!stack2.isEmpty()) {
			size--;
			return stack2.pop();
		} else {

			// push all elements from stack1 to stack2 if stack2 is empty
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}

			// now return top of the stack2
			size--;
			return stack2.pop();
		}
	}

	/**
	 * 
	 * returns the element from head of the queue without removing it else null if
	 * queue is empty
	 */
	public T peek() {

		// return null if queue is empty
		if (isEmpty())
			return null;

		if (!stack2.isEmpty()) {
			return stack2.peek();
		} else {

			// push all elements from stack1 to stack2 if stack2 is empty
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}

			// now return top of the stack2
			return stack2.peek();
		}
	}

	// returns boolean specifying if queue is empty
	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
}
