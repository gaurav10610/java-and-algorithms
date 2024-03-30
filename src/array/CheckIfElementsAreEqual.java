package array;

import java.util.Arrays;

/**
 * Given a list of integer, check if all the numbers of an array can be
 * equalized to a particular number. In a single operation, any element of the
 * array can be either multiplied by 2 or by 3. If it's possible to make all the
 * array elements equal with the given operation then print Yes else print No.
 * <p>
 * Time Complexity - O(N(log2N + log3N))
 */
public class CheckIfElementsAreEqual {

    public static void main(String[] args) {
        int[] array = {50, 75, 15};

        for (int i = 0; i < array.length; i++) {

			/*
			  keep dividing the number by 2 until it is divisible
			 */
            while (array[i] % 2 == 0) {
                array[i] /= 2;
            }

			/*
			  keep dividing the number by 3 until it is divisible
			 */
            while (array[i] % 3 == 0) {
                array[i] /= 3;
            }
        }

        int numberToCheck = array[0];

		/*
		  check if all the numbers in the array are equal
		 */
        if (Arrays.stream(array).anyMatch((number) -> number != numberToCheck)) {
            System.out.println("No all values can't be made equal.");
            return;
        }

        System.out.println("Yes all values can't be made equal.");
    }

}
