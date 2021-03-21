package searchingNsorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Find the Point(Index of minimum element from original sorted array) of Rotation of a rotated
 * Sorted Array
 * 
 * Input - {24,34,56,78,87,12,13}
 * 
 * Output - 5
 * 
 */
public class FindRotationPointInSortedRotatedArray {

  public static void main(String[] args) {

    /**
     * 
     * point of rotation is in the right subarray after taking first mid
     * 
     */
    int[] testArray1 = {21, 24, 56, 78, 87, 12};

    /**
     * 
     * point of rotation is in the left subarray after taking first mid
     * 
     */
    int[] testArray2 = {100, 24, 56, 78, 87};

    /**
     * 
     * point of rotation is exactly at mid after taking first mid
     * 
     */
    int[] testArray3 = {100, 101, 56, 78, 87};

    List<int[]> testArrays = new ArrayList<>();
    testArrays.add(testArray1);
    testArrays.add(testArray2);
    testArrays.add(testArray3);

    testArrays.forEach(array -> {
      int rotationIndex = getRotationIndex(array, 0, array.length - 1) % array.length;
      System.out
          .println("Index of point of rotation for " + Arrays.toString(array) + " is: " + rotationIndex);
    });
  }

  public static int getRotationIndex(int[] array, int start, int end) {

    if (start <= end) {

      /**
       * 
       * check the necessary condition for subarray of size two
       */
      if (end == (start + 1) && array[start] > array[end]) {
        return end;
      } else {

        /**
         * 
         * start with the mid element
         */
        int mid = start + (end - start) / 2;

        /**
         * 
         * check which subarray whether the left sub array or the right sub array contains the point
         * of rotation
         * 
         */
        if (array[mid] > array[end]) {
          return getRotationIndex(array, mid, end);
        }
        return getRotationIndex(array, start, mid);
      }
    }
    return 0;
  }

}
