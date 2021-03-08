package array;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * Given a list of numbers, for each value in the list print the next bigger value from list on it's
 * right if it exist else print -1. Refer below example -
 * 
 * 
 * Input -> [23, 10, 42, 32, 22, 11, 56, 70]
 * 
 * Output -> 42 42 56 56 56 56 70 -1
 *
 */
public class FindNextBiggerValue {

  public static void main(String[] args) {
    int[] numbers = {23, 10, 42, 32, 22, 11, 56, 70};

    /**
     * 
     * stack to keep values to find next bigger
     */
    Stack<ArrayValue> stack = new Stack<>();

    for (int i = 0; i < numbers.length; i++) {
      int currentNumber = numbers[i];

      /**
       * 
       * if stack is not empty then compare current number with the value at the top of the stack if
       * it is smaller then remove the top and assign the cuurent number as next buggest value for
       * the popped stack element
       * 
       * repeat the above steps until stack is empty and above mentioned condition is matched
       * 
       */
      while (!stack.isEmpty() && stack.peek().number < currentNumber) {

        /**
         * 
         * pop the top value
         */
        ArrayValue top = stack.pop();

        /**
         * 
         * assign the current number as next biggest value for popped stack element
         */
        numbers[top.index] = currentNumber;
      }

      /**
       * 
       * finally add the current number in stack
       */
      stack.add(new ArrayValue(currentNumber, i));
    }

    /**
     * 
     * assign -1 for those elements for which next bigger value doesn't exist in array
     */
    while (!stack.isEmpty()) {
      ArrayValue top = stack.pop();
      numbers[top.index] = -1;
    }

    System.out.print(Arrays.toString(numbers));
  }

}


/**
 * 
 * data structure to store element and it's position in original array while pushing them in stack
 *
 */
class ArrayValue {
  public int number;
  public int index;

  public ArrayValue(int number, int index) {
    this.number = number;
    this.index = index;
  }
}
