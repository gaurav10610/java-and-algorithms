package array;

import java.util.Arrays;

/**
 * 
 * Find the Number Occurring Odd Number of Times
 * 
 * Input : array = {1, 2, 3, 2, 3, 1, 3}
 * 
 * Output : 3
 * 
 * Time Complexity - O(N)
 *
 */
public class FindNumberOccurOddTimes {

	public static void main(String[] args) {
		int[] array = { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 5, 2 };

		/*
		  XOR of two elements is 0 if both elements are same and XOR of a number x with
		  0 is x
		 */
		int result = Arrays.stream(array).reduce((a, b) -> a ^ b).getAsInt();

		System.out.println("Number occurred odd number of times is: " + result);
	}

}
