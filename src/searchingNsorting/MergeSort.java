package searchingNsorting;

import java.util.*;

public class MergeSort {

  public static void main(String[] args) {
    int[] numbers = {45, 23, 2, 1, 67, 22, 11, 54, 32, 21, 11, 56, 100, 99, 65, 77, 78, 87};
    System.out.println("Sorted array is below: ");
    mergeSort(numbers, 0, numbers.length - 1);

    Arrays.stream(numbers).forEach((element) -> {
      System.out.print(element + " ");
    });
  }

  // Merge Sort
  public static void mergeSort(int[] numbers, int l, int r) {

    if (l < r) {
      // Find the middle point
      int m = l + (r - l) / 2;

      // Sort first and second halves
      mergeSort(numbers, l, m);
      mergeSort(numbers, m + 1, r);

      // Merge the sorted halves
      merge(numbers, l, m, r);
    }
  }

  public static void merge(int[] arr, int l, int m, int r) {

    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    /* Create temp arrays */
    int L[] = new int[n1];
    int R[] = new int[n2];

    /* Copy data to temp arrays */
    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];


    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarry array
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    /* Copy remaining elements of L[] if any */
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    /* Copy remaining elements of R[] if any */
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

}
