package library;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * custom implementation of stack using two queues
 * 
 */
public class StackUsingQueue<T> {

	private Queue<T> queue1;
	private Queue<T> queue2;
	private int size;

	public StackUsingQueue() {
		queue1 = new LinkedList<>();
		queue2 = new LinkedList<>();
		size = 0;
	}

	/**
	 * 
	 * this will push an element on top of the stack
	 */
	public void push(T element) {
		size++;
		queue1.offer(element);

		/**
		 * add all the elements from queue2 to queue1 to maintain the LIFO order of
		 * stack
		 */
		while (!queue2.isEmpty()) {
			queue1.offer(queue2.poll());
		}

		/**
		 * swap queue1 and queue2
		 */
		Queue<T> queue3 = queue1;
		queue1 = queue2;
		queue2 = queue3;
	}

	/**
	 * 
	 * returns the top of the stack with its removal from stack else null if stack
	 * is empty
	 */
	public T pop() {
		if (isEmpty()) {
			return null;
		}
		size--;
		return queue2.poll();
	}

	/**
	 * 
	 * returns the top of the stack without removing it else null if stack is empty
	 */
	public T peek() {
		if (isEmpty()) {
			return null;
		}
		return queue2.peek();
	}

	/**
	 * 
	 * returns the current size of the stack
	 */
	public int size() {
		return size;
	}

	/**
	 * returns boolean specifying if stack is empty or not
	 */
	public boolean isEmpty() {
		return size == 0;
	}
}
