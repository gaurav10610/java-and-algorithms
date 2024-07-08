package dsalgo.queue;

import dsalgo.library.QueueUsingStack;

/**
 * 
 * Design a queue using stack and implement following methods -
 * 
 * 1. offer(element) - adds an element in the queue
 * 
 * 2. element poll() - removes and returns the element from head of the queue
 * 
 * 3. element peek() - returns the element from head of the queue without
 * removing it
 * 
 * 4. boolean isEmpty() - returns boolean specifying if queue is empty
 *
 */
public class QueueUsingTwoStacks {

	public static void main(String[] args) {
		QueueUsingStack<Integer> queue = new QueueUsingStack<Integer>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);

		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());

	}

}
