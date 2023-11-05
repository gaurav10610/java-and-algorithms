package array;

import java.util.Arrays;

/**
 * 
 * Given an array A[] of n numbers and another number x, determines whether or
 * not there exist two elements in S whose sum is exactly X.
 * 
 * Input: array = {0, -1, 2, -3, 1}
 * 
 * sum = -2
 * 
 * Output: -3, 1
 * 
 * Time Complexity - O(NlogN) + O(N)
 * 
 */
public class FindPairWithSumX {

	public static void main(String[] args) {
		int[] array = { 0, -1, 2, -3, 1 };

		/**
		 * 
		 * time complexity - O(NlogN)
		 * 
		 */
		Arrays.sort(array);

		int start = 0;
		int end = array.length - 1;

		int X = 0;

		/**
		 * 
		 * time complexity - O(N)
		 * 
		 */
		while (start < end) {

			int sum = array[start] + array[end];

			if (sum == X) {

				System.out.println("sum exist in the array");
				return;
			} else if (sum > X) {
				end--;
			} else {
				start++;
			}
		}

		System.out.println("sum does not exist in the array");
	}

}
