package searchingNsorting;

import library.ArrayUtils;

public class FindClosestPairWithSumX {

	public static void main(String[] args) {
		int ar1[] = { 1, 4, 5, 7 };
		int ar2[] = { 10, 20, 30, 40 };
		int sum = 38;
		int left = 0;
		int right = ar2.length - 1;
		int diff = Integer.MAX_VALUE;
		int[] result = { 0, ar2.length - 1 };

		while (left < ar1.length && right >= 0) {
			if (Math.abs(ar1[left] + ar2[right] - sum) < diff) {
				diff = Math.abs(ar1[left] + ar2[right] - sum);
				result[0] = ar1[left];
				result[1] = ar2[right];
			}

			if ((ar1[left] + ar2[right]) < sum) {
				left++;
			} else {
				right--;
			}
		}

		ArrayUtils.printIntArray(result);
	}

}
