package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive
 * days just before the given day, for which the price of the stock on the current day is less than
 * or equal to its price on the given day.
 * 
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the
 * span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 * 
 * trick - start traversing from the end and just find the next greater element and count the days
 * in between
 * 
 */
public class StockSpanProblem {

  public static void main(String[] args) {

    int[] stockPrices = {100, 80, 60, 70, 60, 75, 85};
    int[] stockSpan = new int[stockPrices.length];
    Arrays.fill(stockSpan, 1);
    Stack<Integer> stack = new Stack<>();

    int i = stockPrices.length - 1;
    while (i >= 0) {

      while (!stack.isEmpty() && stockPrices[stack.peek()] < stockPrices[i]) {
        int poppedIndex = stack.pop();
        stockSpan[poppedIndex] = poppedIndex - i;
      }
      stack.push(i);
      i--;
    }
    System.out.print(Arrays.toString(stockSpan));
  }

}
