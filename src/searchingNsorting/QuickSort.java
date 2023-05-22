package searchingNsorting;

import library.ArrayUtils;

/**
 * Quick Sort Algorithm
 * 
 * Time Complexity - Best Case - O(NlogN), Average Case - O(NlogN), Worst Case - O(N^2) 
 * 
 * Space Complexity - O(1)
 *
 */
public class QuickSort {

  public static void main(String[] args) {
    int array[] = {45, 23, 2, 1, 67, 22, 11, 54, 32, 21, 11, 56, 100, 99, 65, 77, 78, 87};
    quickSort(array, 0, array.length - 1);
    ArrayUtils.printIntArray(array);
  }

  public static void quickSort(int[] array, int start, int end) {
    int i = partition(array, start, end);

    // If conditions are very important
    if (i > start)
      quickSort(array, start, i - 1);
    if (end > i)
      quickSort(array, i + 1, end);
  }

  public static int partition(int[] array, int start, int end) {
    int i = start;
    int pivot = array[start];
    int j = i + 1;

    while (j <= end) {
      if (pivot >= array[j]) {
        i++;
        swap(array, i, j);
      }
      j++;
    }
    swap(array, start, i);
    return i;
  }

  public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}
