package dsalgo.searchingNsorting;

import java.util.Arrays;
import dsalgo.library.HeapUtils;

/**
 * 
 * Given an array of N elements, where each element is at most K away from its
 * target position, devise an algorithm that sorts in O(N log K) time.
 * 
 * 
 * Example 1 -
 * 
 * Input: arr[] = {6, 5, 3, 2, 8, 10, 9}, K = 3
 * 
 * Output: arr[] = {2, 3, 5, 6, 8, 9, 10}
 * 
 * 
 * Example 2 -
 * 
 * Input: arr[] = {10, 9, 8, 7, 4, 70, 60, 50}, K = 4
 * 
 * Output: arr[] = {4, 7, 8, 9, 10, 50, 60, 70}
 */
public class SortKSortedArray {

	public static void main(String[] args) {

		int array[] = { 3, 6, 2, 12, 56, 8 };
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
			HeapUtils.minHeapify(heap, --heapSize, 0);
			p++;
		}

		System.out.println(Arrays.toString(array));
	}
}
