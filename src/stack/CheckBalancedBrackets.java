package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * 
 * Check for Balanced Brackets in an expression (well-formedness) using Stack
 * 
 * Examples -
 * 
 * Input1: exp = “[()]{}{[()()]()}”
 * 
 * Output1: Balanced
 *
 * Input2: exp = “[(])”
 * 
 * Output2: Not Balanced
 *
 */
public class CheckBalancedBrackets {

  public static void main(String[] args) {

    String expression1 = "[()]{}{[()()]()}";
    String expression2 = "[(])";

    List<String> expressions = new ArrayList<>();
    expressions.add(expression1);
    expressions.add(expression2);

    Stack<Character> stack = new Stack<>();

    for (String expression : expressions) {

      /**
       * 
       * empty the stack
       */
      stack.clear();

      boolean isBalancedFlag = true;

      for (char c : expression.toCharArray()) {

        switch (c) {

          case '(':
            stack.add(c);
            break;

          case ')':

            /**
             * 
             * iterate/keep popping the stack until an opening bracket is not found in the
             * expression
             * 
             * 
             */
            while (!stack.isEmpty() && stack.peek().charValue() != '(') {
              stack.pop();
            }

            /**
             * 
             * pop the opening bracket from the stack
             * 
             */
            if (!stack.isEmpty() && stack.peek().charValue() == '(') {
              stack.pop();
            } else {

              /**
               * 
               * top element should be an opening bracket in the stack else expression is not
               * balanced
               * 
               */
              isBalancedFlag = false;
              break;
            }
            break;

          case '[':
            stack.add(c);
            break;

          case ']':
            while (!stack.isEmpty() && stack.peek().charValue() != '[') {
              stack.pop();
            }

            if (!stack.isEmpty() && stack.peek().charValue() == '[') {
              stack.pop();
            } else {
              isBalancedFlag = false;
              break;
            }
            break;

          case '{':
            stack.add(c);
            break;

          case '}':

            while (!stack.isEmpty() && stack.peek().charValue() != '{') {
              stack.pop();
            }

            if (!stack.isEmpty() && stack.peek().charValue() == '{') {
              stack.pop();
            } else {
              isBalancedFlag = false;
              break;
            }
            break;
        }
      }

      /**
       * 
       * if stack is empty after traversing whole expression then the expression is balanced
       * 
       */
      if (isBalancedFlag && stack.isEmpty()) {
        System.out.println(expression + " is balanced");
      } else {
        System.out.println(expression + " is not balanced");
      }
    }
  }

}
