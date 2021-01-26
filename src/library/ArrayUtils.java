package library;

import java.util.Arrays;

public class ArrayUtils {

  public static void printIntArray(int[] array) {
    Arrays.stream(array).forEach((value) -> {
      System.out.print(value + " ");
    });
    System.out.println();
  }

  public static void printInt2DArray(int[][] array) {
    Arrays.stream(array).forEach((row) -> {
      Arrays.stream(row).forEach((value) -> {
        System.out.print(value + " ");
      });
      System.out.println();
    });
    System.out.println();
  }

  public static void swap(int[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
}
