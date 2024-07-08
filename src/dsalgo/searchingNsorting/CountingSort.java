package dsalgo.searchingNsorting;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int[] array = { 1, 4, 1, 2, 7, 5, 2 };
		int[] sortedArray = new int[array.length];

		int range = Arrays.stream(array).max().getAsInt() + 1;
		int[] countArray = new int[range];

		for (int x : array) {
			countArray[x]++;
		}

		for (int i = 1; i < countArray.length; i++) {
			countArray[i] = countArray[i] + countArray[i - 1];
		}

		for (int x : array) {
			sortedArray[countArray[x] - 1] = x;
			countArray[x]--;
		}

		System.out.print(Arrays.toString(sortedArray));
	}

}
