package searchingNsorting;

import library.ArrayUtils;
import library.HeapUtils;

public class SortKSortedArray {

  public static void main(String[] args) {
    int array[] = {3, 6, 2, 12, 56, 8};
    int k = 3;
    int heapSize = k + 1;
    int[] heap = new int[heapSize];

    for (int p = 0; p < heapSize; p++) {
      heap[p] = array[p];
    }

    for (int i = heapSize / 2 - 1; i >= 0; i--) {
      HeapUtils.minHeapify(heap, heapSize, i);
    }
    //ArrayUtils.printIntArray(heap);

    int q = 0;
    for (int s = heapSize; s < array.length; s++) {
      array[q] = heap[0];
      heap[0] = array[s];
      HeapUtils.minHeapify(heap, heapSize, 0);
      q++;
    }
    
    for (int t = heapSize - 1; t >= 0; t--) {
      array[q] = heap[0];
      heap[0] = heap[t];
      HeapUtils.minHeapify(heap, t, 0);
      q++;
    }
    ArrayUtils.printIntArray(array);
  }
}
