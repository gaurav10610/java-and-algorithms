package dsalgo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * You are given two integer arrays nums1 and nums2 both of unique elements,
 * where nums1 is a subset of nums2.
 * 
 * Find all the next greater numbers for nums1's elements in the corresponding
 * places of nums2.
 * 
 * The Next Greater Number of a number x in nums1 is the first greater number to
 * its right in nums2. If it does not exist, return -1 for this number.
 * 
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * 
 * Output: [-1,3,-1]
 *
 * Time complexity = O(m + n)
 * 
 */
public class FindNextGreaterFromTwoArray {

	public static void main(String[] args) {

		int[] num1 = { 4, 1, 2, 10 };
		int[] num2 = { 1, 6, 4, 2, 3, 8, 10 };

		System.out.println(Arrays.toString(num1));

		int[] result = new int[num1.length];
		Arrays.fill(result, -1);

		Stack<Integer> stack = new Stack<>();

		Map<Integer, Integer> map = new HashMap<>();

		/**
		 * 
		 * first find out next greater for each element in num2 and store it in hash map
		 * 
		 */
		for (int x : num2) {

			/**
			 * 
			 * keep popping the stack until the top element is smaller than the current
			 * element in consideration and update the next greater for popped elements in
			 * the hash map
			 * 
			 */
			if (!stack.isEmpty() && stack.peek() < x) {
				int popped = stack.pop();
				map.put(popped, x);
			}
			stack.push(x);
		}

		int i = 0;

		/**
		 * 
		 * find the next greater for corresponding element in num2 from the hash map
		 */
		while (i < num1.length) {
			if (map.containsKey(num1[i])) {
				result[i] = map.get(num1[i]);
			}
			i++;
		}

		System.out.print(Arrays.toString(result));
	}

}
