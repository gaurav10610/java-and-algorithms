package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem - check if string is made of unique characters or not
 * 
 * Examples -
 * 
 * - gaurav - invalid
 * 
 * - shikha - valid
 * 
 * Expected time complexity -
 * 
 * - with extra space - O(n)
 * 
 * - without extra space - O(nlogn)
 */
public class CheckDuplicateCharacters {

	public static void main(String[] args) {
		String string1 = "Gaurav";
		String string2 = "Shikar";

		if (validateStringWithExtraSpace(string1)) {
			System.out.printf("string '%s' is valid", string1);
			System.out.println();
		} else {
			System.out.printf("string '%s' is invalid", string1);
			System.out.println();
		}

		if (validateStringWithoutExtraSpace(string1.toCharArray())) {
			System.out.printf("string '%s' is valid", string1);
			System.out.println();
		} else {
			System.out.printf("string '%s' is invalid", string1);
			System.out.println();
		}

		if (validateStringWithExtraSpace(string2)) {
			System.out.printf("string '%s' is valid", string2);
			System.out.println();
		} else {
			System.out.printf("string '%s' is invalid", string2);
			System.out.println();
		}

		if (validateStringWithoutExtraSpace(string2.toCharArray())) {
			System.out.printf("string '%s' is valid", string2);
			System.out.println();
		} else {
			System.out.printf("string '%s' is invalid", string2);
			System.out.println();
		}

	}

	/**
	 * validate whether string is made of unique characters or not using extra space
	 * 
	 * @param string input string
	 * @return true for valid string or vice versa
	 * 
	 *         time complexity - O(n)
	 */
	public static boolean validateStringWithExtraSpace(String string) {

		/**
		 * hashset to keep track of duplicate characters
		 */
		Set<Character> charSet = new HashSet<>();

		for (char c : string.toCharArray()) {

			if (charSet.contains(c)) {
				return false;
			}
			charSet.add(c);
		}
		return true;
	}

	/**
	 * validate whether string is made of unique characters or not without using
	 * extra space
	 * 
	 * @param string input character array
	 * @return true for valid string or vice versa
	 * 
	 *         time complexity - O(nlogn)
	 */
	public static boolean validateStringWithoutExtraSpace(char[] string) {

		/**
		 * sorting cost - O(nlogn)
		 */
		Arrays.sort(string);

		int length = string.length;

		/**
		 * cost - O(n)
		 */
		for (int i = 0; i < length - 1; i++) {

			if (string[i] == string[i + 1]) {
				return false;
			}
		}
		return true;
	}

}
