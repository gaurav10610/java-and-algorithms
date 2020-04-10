package searchingNsorting;

import java.util.Arrays;

public class CountingSortWithNegative {

  public static void main(String[] args) {
    int[] array = {1, -4, 1, -2, -7, 5, 2};
    int[] sortedArray = new int[array.length];

    int min = Arrays.stream(array).min().getAsInt();
    int max = Arrays.stream(array).max().getAsInt();
    int range = max - min + 1;
    int[] countArray = new int[range];

    for (int x : array) {
      countArray[x - min]++;
    }

    for (int i = 1; i < countArray.length; i++) {
      countArray[i] = countArray[i] + countArray[i - 1];
    }

    for (int x : array) {
      sortedArray[countArray[x - min] - 1] = x;
      countArray[x - min]--;
    }
    
    for (int x : sortedArray) {
      System.out.print(x + " ");
    }
  }

}
