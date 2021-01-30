package common;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfix {

  public static Map<Character, Integer> priority = new HashMap<Character, Integer>();

  public static void main(String[] args) {
    String infix = "1+(2+3)-(5-4)*6/8";
    StringBuilder postfix = new StringBuilder("");

    priority.put('+', 1);
    priority.put('-', 1);
    priority.put('/', 2);
    priority.put('*', 2);
    priority.put('^', 3);

    Stack<Character> operatorStack = new Stack<Character>();

    // Conversion logic
    for (int i = 0; i < infix.length(); i++) {
      char c = infix.charAt(i);

      if (!(isOperator(c) || isBracket(c))) {

        // Its an operand
        postfix.append(c);
      } else {

        if (c == '(') {

          operatorStack.push(c);
        } else if (c == ')') {

          while (!operatorStack.isEmpty() && operatorStack.peek().charValue() != '(') {
            postfix.append(operatorStack.pop().charValue());
          }

          if (!operatorStack.isEmpty() && operatorStack.peek().charValue() != '(') {
            System.out.println("Invalid Expression.");
            return;
          } else {
            operatorStack.pop();
          }
        } else {

          if (operatorStack.isEmpty() || operatorStack.peek().charValue() == '('
              || getOperatorPriority(operatorStack.peek().charValue()) < getOperatorPriority(c)) {

            operatorStack.push(c);
          } else {

            while (!operatorStack.isEmpty() && operatorStack.peek().charValue() != '('
                && getOperatorPriority(operatorStack.peek().charValue()) >= getOperatorPriority(
                    c)) {

              postfix.append(operatorStack.pop().charValue());
            }
            operatorStack.push(c);
          }
        }
      }
    }

    while (!operatorStack.isEmpty()) {
      if (operatorStack.peek().charValue() == '(') {
        System.out.println("Invalid Expression.");
        return;
      }
      postfix.append(operatorStack.pop());
    }

    System.out.println("Infix expression: " + infix);
    System.out.println("Postfix expression: " + postfix.toString());
  }

  public static boolean isOperator(char s) {
    return priority.containsKey(s);
  }

  public static boolean isBracket(char s) {
    return (s == '(' || s == ')') ? true : false;
  }

  public static int getOperatorPriority(char s) {
    return priority.get(s).intValue();
  }
}
