package stack;

import java.util.Stack;

/**
 * Given a string, reverse it using stack
 *
 */
public class ReverseString {

  public static void main(String[] args) {
    String string = "gaurav kumar yadav";
    System.out.println("string: " + string);
    System.out.println("reversed string: " + reverseString(string));
  }

  public static String reverseString(String string) {
    StringBuilder reversedString = new StringBuilder("");
    Stack<Character> stack = new Stack<>();

    // insert all characters in stack
    for (char c : string.toCharArray()) {
      stack.push(c);
    }

    // pop charcters from stack and append in reversed string
    while (!stack.isEmpty()) {
      reversedString.append(stack.pop().charValue());
    }
    return reversedString.toString();
  }

}
