package dsalgo.stack;

import java.util.Stack;

/**
 * 
 * Given a stack, sort it using recursion. Use of any loop constructs like
 * while, for..etc is not allowed. We can only use the following ADT functions
 * on Stack S:
 *
 * isEmpty(S)
 * 
 * push(S)
 * 
 * pop(S)
 * 
 * peek(S)
 *
 */
public class SortStackUsingRecursion {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(4);
		stack.push(1);
		stack.push(2);
		stack.push(5);

		System.out.println("Original stack: ");
		System.out.print(stack);
		System.out.println("\n");

		sortStack(stack);

		System.out.println("Sorted stack: ");
		System.out.print(stack);
	}

	public static void sortStack(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int topElement = stack.pop();
			sortStack(stack);
			insertInSortedStack(topElement, stack);
		}
	}

	public static void insertInSortedStack(int x, Stack<Integer> stack) {

		if (stack.isEmpty() || stack.peek() < x) {
			stack.push(x);
		} else {
			int topElement = stack.pop();
			insertInSortedStack(x, stack);
			stack.push(topElement);
		}
	}

}
