package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an array A[] of n numbers and another number x, determines whether or not there exist two
 * elements in S whose sum is exactly X.
 * 
 * Input: arr[] = {0, -1, 2, -3, 1}
 * 
 * sum = -2
 * 
 * Output: -3, 1
 */
public class FindPairWithSumX {

  public static void main(String[] args) {
    int[] array = {0, -1, 2, -3, 1};

    int sum = -2;

    Set<Integer> set = new HashSet<>();

    for (int number : array) {

      int remainingSum = sum - number;
      if (set.contains(remainingSum)) {
        System.out.print("Pair: (" + number + "," + remainingSum + ")");
        return;
      }
      set.add(number);
    }
    System.out.print("No pair exist with given sum");
  }

}
