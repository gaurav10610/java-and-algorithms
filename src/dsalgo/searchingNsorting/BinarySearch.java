package dsalgo.searchingNsorting;

/**
 * Find a given value in a sorted array
 * 
 * Algorithm - Binary Search
 * 
 * Time Complexity - O(N), N - No. of elements in the array
 * 
 *
 */
public class BinarySearch {

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 3, 4, 11 };

		int x = 11;

		int index = binarySearch(array, x, 0, array.length - 1);

		System.out.printf("value: %d is found at index: %d", x, index);
	}

	/**
	 * perform binary search on array to recursively find the given value x
	 * 
	 * @param array
	 * @param x
	 * @param left
	 * @param right
	 * @return
	 */
	public static int binarySearch(int[] array, int x, int left, int right) {

		/*
		  stop after crossover point
		 */
		if (left <= right) {

			/*
			  find the middle index
			 */
			int mid = left + (right - left) / 2;

			/*
			  check if element found at middle
			 */
			if (array[mid] == x) {

				return mid;
			}

			/*
			  if middle element is bigger in value then search in left sub array
			 */
			if (array[mid] > x) {

				return binarySearch(array, x, left, mid - 1);
			}

			/*
			  if middle element is smaller in value then search in right sub array
			 */
			return binarySearch(array, x, mid + 1, right);
		}

		/*
		  return -1 if element not to be found
		 */
		return -1;
	}

}
