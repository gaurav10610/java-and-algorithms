package dsalgo.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 
 * 
 * Check for Balanced Brackets in an expression (well-formedness) using Stack
 * 
 * Examples -
 * 
 * Input1: exp = �[()]{}{[()()]()}�
 * 
 * Output1: Balanced
 *
 * Input2: exp = �[(])�
 * 
 * Output2: Not Balanced
 *
 */
public class CheckBalancedBrackets {

	public static void main(String[] args) {

		String expression1 = "[()]{}{[()()]()}";
		String expression2 = "[(])";

		List<String> expressions = Arrays.asList(expression1, expression2);

		expressions.forEach(expression -> System.out.printf("is expression: %s is valid? %s \n", expression,
				isValidExpression(expression)));

	}

	public static boolean isValidExpression(String expression) {
		Stack<Character> stack = new Stack<>();

		for (char c : expression.toCharArray()) {

			if (c == '[' || c == '{' || c == '(') {
				stack.push(c);
			} else if (c == ']') {

				if (stack.peek() == '[') {
					stack.pop();
				} else {
					return false;
				}
			} else if (c == '}') {

				if (stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
			} else if (c == ')') {

				if (stack.peek() == '(') {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		/**
		 * 
		 * if stack is empty after traversing whole expression then the expression is
		 * balanced
		 * 
		 */
		return stack.isEmpty();
	}

}
