package basic;

import java.util.ArrayList;
import java.util.List;

public class ClosestPair {

  public static void main(String[] args) {
    int[] sortedArray = {10, 22, 28, 29, 30, 40};
    int x = 29;
    findClosestPairIndices(sortedArray, x).forEach((index) -> {
      System.out.println("Element: " + sortedArray[index.intValue()]);
    });

  }

  public static List<Integer> findClosestPairIndices(int[] sortedArray, int x) {
    List<Integer> indices = new ArrayList<Integer>();

    int left = 0;
    int right = sortedArray.length - 1;
    int diff = Integer.MAX_VALUE;
    int left_result = 0;
    int right_result = 0;

    while (left < right) {

      if (Math.abs(sortedArray[left] + sortedArray[right] - x) < diff) {
        left_result = left;
        right_result = right;
        diff = Math.abs(sortedArray[left] + sortedArray[right] - x);
      }

      if (sortedArray[left] + sortedArray[right] < x) {
        left++;
      } else {
        right--;
      }

    }

    indices.add(left_result);
    indices.add(right_result);

    return indices;
  }

}
