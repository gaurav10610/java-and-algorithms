package searchingNsorting;

import java.util.Arrays;

public class CountingSort {

  public static void main(String[] args) {
    int[] array = {1, 4, 1, 2, 7, 5, 2};
    int[] sortedArray = new int[array.length];

    int range = Arrays.stream(array).max().getAsInt() + 1;
    int[] countArray = new int[range];

    for (int x : array) {
      countArray[x]++;
    }

    /*
     * Change count[i] so that count[i] now contains actual position of this element in output array
     */
    for (int x = 1; x < countArray.length; x++) {
      countArray[x] = countArray[x] + countArray[x - 1];
    }

    for (int x : array) {
      sortedArray[countArray[x] - 1] = x;
      countArray[x]--;
    }

    for (int x : sortedArray) {
      System.out.print(x + " ");
    }
  }

}
