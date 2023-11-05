package stack;

import library.StackUsingQueue;

/**
 * Design a stack using queue and implement following methods -
 * 
 * 1. push(element)
 * 
 * 2. element pop()
 * 
 * 3. element peek()
 * 
 * 4. boolean isEmpty()
 *
 */
public class StackUsingTwoQueues {
	public static void main(String[] args) {

		StackUsingQueue<Integer> stack = new StackUsingQueue<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println("current size: " + stack.size());
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());

		System.out.println("current size: " + stack.size());
	}
}