package array;

import java.util.Stack;

/**
 * 
 * Find all the LEADERS in the array. An element is leader if it is greater than
 * all the elements to its right side. And the rightmost element is always a
 * leader.
 * <p>
 * For example in the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 * <p>
 * Time Complexity - O(N)
 *
 */
public class FindLeaders {

	public static void main(String[] args) {

		int[] array = { 16, 17, 4, 3, 5, 2 };

		Stack<Integer> stack = new Stack<>();

		for (int number : array) {

			/*
			  keep popping the elements from the stack for which we have found a greater
			  number
			 */
			while (!stack.isEmpty() && stack.peek() <= number) {
				stack.pop();
			}

			stack.add(number);
		}

		System.out.print("Leaders are: " + stack);
	}

}
