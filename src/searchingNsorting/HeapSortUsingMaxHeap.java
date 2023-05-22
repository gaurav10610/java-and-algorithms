package searchingNsorting;

import library.ArrayUtils;
import library.HeapUtils;

public class HeapSortUsingMaxHeap {

  public static void main(String[] args) {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int size = arr.length;

    for (int i = size / 2 - 1; i >= 0; i--) {
      HeapUtils.maxHeapify(arr, size, i);
    }

    for (int j = size - 1; j >= 0; j--) {
      int temp = arr[j];
      arr[j] = arr[0];
      arr[0] = temp;
      HeapUtils.maxHeapify(arr, j, 0);
    }

    ArrayUtils.printIntArray(arr);
  }

}
