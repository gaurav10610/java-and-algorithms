package searchingNsorting;

import java.util.Arrays;
import library.HeapUtils;

public class SortKSortedArray {

  public static void main(String[] args) {

    int array[] = {3, 6, 2, 12, 56, 8};
    int k = 3;
    int heapSize = k + 1;
    int[] heap = new int[heapSize];

    for (int i = 0; i < heapSize; i++) {
      heap[i] = array[i];
    }

    for (int i = heapSize / 2 - 1; i >= 0; i--) {
      HeapUtils.minHeapify(heap, heapSize, i);
    }

    int p = 0;

    for (int i = heapSize; i < array.length; i++) {
      array[p] = heap[0];
      heap[0] = array[i];
      HeapUtils.minHeapify(heap, heapSize, 0);
      p++;
    }

    while (heapSize > 0) {
      array[p] = heap[0];
      heap[0] = heap[heapSize - 1];
      HeapUtils.minHeapify(heap, heapSize--, 0);
      p++;
    }

    System.out.println(Arrays.toString(array));
  }
}
