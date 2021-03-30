package stack;

import java.util.Stack;

/**
 * 
 * Write a recursive logic to reverse the stack.You are not allowed to use loop constructs like
 * while, for..etc, and you can only use the following ADT functions on Stack S:
 * 
 * isEmpty(S)
 * 
 * push(S)
 * 
 * pop(S)
 *
 */
public class ReverseStackUsingRecursion {

  public static void main(String[] args) {

    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    System.out.println("Original stack: ");
    System.out.print(stack);
    System.out.println("\n");

    reverseStack(stack);

    System.out.println("Reversed stack: ");
    System.out.print(stack);
  }

  public static void reverseStack(Stack<Integer> stack) {
    if (!stack.isEmpty()) {
      int poppedElement = stack.pop();
      reverseStack(stack);
      insertAtBottom(poppedElement, stack);
    }
  }

  public static void insertAtBottom(int x, Stack<Integer> stack) {

    if (stack.isEmpty()) {
      stack.push(x);
    } else {
      int poppedElement = stack.pop();
      insertAtBottom(x, stack);
      stack.push(poppedElement);
    }
  }

}
