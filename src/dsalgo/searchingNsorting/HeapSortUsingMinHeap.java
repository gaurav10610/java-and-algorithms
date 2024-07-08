package dsalgo.searchingNsorting;

import java.util.Arrays;
import dsalgo.library.HeapUtils;

public class HeapSortUsingMinHeap {

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		int size = arr.length;

		for (int i = size / 2 - 1; i >= 0; i--) {
			HeapUtils.minHeapify(arr, size, i);
		}

		for (int j = size - 1; j >= 0; j--) {
			int temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			HeapUtils.minHeapify(arr, j, 0);
		}
		System.out.print(Arrays.toString(arr));
	}

}
