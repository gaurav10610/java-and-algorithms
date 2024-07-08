package dsalgo.searchingNsorting;

import java.util.Arrays;

/**
 * Implement counting sort on an array of integers containing positive and
 * negative values
 * 
 * Hints -
 * 
 * 1. Range for count array - (max - min + 1)
 * 
 * 2. Offset x's values by (x - min)
 *
 */
public class CountingSortWithNegative {

	public static void main(String[] args) {
		int[] array = { 1, -4, 1, -2, -7, 5, 2 };
		int[] sortedArray = new int[array.length];

		int min = Arrays.stream(array).min().getAsInt();
		int max = Arrays.stream(array).max().getAsInt();
		int range = max - min + 1;
		int[] countArray = new int[range];

		for (int x : array) {
			countArray[x - min]++;
		}

		for (int i = 1; i < countArray.length; i++) {
			countArray[i] = countArray[i] + countArray[i - 1];
		}

		for (int x : array) {
			sortedArray[countArray[x - min] - 1] = x;
			countArray[x - min]--;
		}

		System.out.println("sorted array: " + Arrays.toString(sortedArray));
	}

}
