package dsalgo.searchingNsorting;

import dsalgo.library.ArrayUtils;

/**
 * Merge Sort Algorithm
 * 
 * Time Complexity - Best Case - O(NlogN), Average Case - O(NlogN), Worst Case -
 * O(NlogN)
 * 
 * Space Complexity - O(1)
 *
 */
public class MergeSort {

	public static void main(String[] args) {

		int[] array = { 45, 23, 2, 1, 67, 22, 11, 54, 32, 21, 11, 56, 100, 99, 65, 77, 78, 87 };

		mergeSort(array, 0, array.length - 1);

		ArrayUtils.printIntArray(array);
	}

	public static void mergeSort(int[] array, int left, int right) {

		if (left < right) {

			int mid = left + (right - left) / 2;

			/*
			 * sort left sub-array
			 */
			mergeSort(array, left, mid);

			/*
			 * sort right sub-array
			 */
			mergeSort(array, mid + 1, right);

			/*
			 * merge both the sorted arrays
			 */
			merge(array, left, mid, right);
		}
	}

	public static void merge(int[] array, int left, int mid, int right) {

		/*
		 * mid-element will be included in the left array
		 */
		int leftSize = mid - left + 1;
		int rightSize = right - mid;

		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[rightSize];

		for (int i = 0; i < leftSize; i++) {
			leftArray[i] = array[left + i];
		}

		for (int i = 0; i < rightSize; i++) {
			rightArray[i] = array[mid + 1 + i];
		}

		int i = 0; // index for leftArray
		int j = 0; // index for rightArray

		int k = left; // index for sorted array

		while (i < leftSize && j < rightSize) {

			/*
			 * if element from left sub array is smaller than keep it prior to corresponding
			 * element from right sub array in the sorted array
			 */
			if (leftArray[i] <= rightArray[j]) {

				array[k] = leftArray[i];
				i++;
				k++;
				continue;
			}

			/*
			 * if element from right sub array is smaller than keep it prior to
			 * corresponding element from left sub array in the sorted array
			 */
			array[k] = rightArray[j];
			j++;
			k++;
		}

		/*
		 * see if any elements remaing in left sub array
		 */
		while (i < leftSize) {

			array[k] = leftArray[i];
			i++;
			k++;
		}

		/*
		 * see if any elements remaining in right sub array
		 */
		while (j < rightSize) {

			array[k] = rightArray[j];
			j++;
			k++;
		}
	}

}
