package dsalgo.searchingNsorting;

import java.util.Arrays;

/**
 * 
 * Problem - Find the Point (Index of minimum element from original sorted array) of
 * Rotation in a rotated Sorted Array
 * 
 * Input - { 24, 34, 56, 78, 87, 12, 13 }
 * 
 * Output - 5
 * 
 */
public class FindRotationPointInSortedRotatedArray {

	public static void main(String[] args) {

		/*
		  point of rotation is in the right subarray after taking first mid
		 */
		int[] testArray1 = { 21, 24, 56, 78, 87, 12 };

		/*
		  point of rotation is in the left subarray after taking first mid
		 */
		int[] testArray2 = { 100, 24, 56, 78, 87 };

		/*
		  point of rotation is exactly at mid after taking first mid
		 */
		int[] testArray3 = { 100, 101, 56, 78, 87 };

		Arrays.asList(testArray1, testArray2, testArray3)
				.forEach(array -> System.out.printf("Index of point of rotation for %s is: %d \n",
						Arrays.toString(array), findRotationIndex(array, 0, array.length - 1)));
	}

	public static int findRotationIndex(int[] array, int start, int end) {

		if (start <= end) {

			int mid = start + (end - start) / 2;

			/*
			  check for condition [10, 3]
			  10 is at mid
			 */
			if (mid < end && array[mid] > array[mid + 1]) {
				return mid + 1;
			}

			/*
			  check for condition [10, 3]
			  3 is at mid
			 */
			if (mid > start && array[mid - 1] > array[mid]) {
				return mid;
			}

			/*
			  compare middle element with the last element to check if either go to right
			 */
			if (array[end] > array[mid]) {
				return findRotationIndex(array, start, mid - 1);
			}

			return findRotationIndex(array, mid + 1, end);
		}

		return 0;
	}

}
