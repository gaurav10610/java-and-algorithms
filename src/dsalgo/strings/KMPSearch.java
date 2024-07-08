package dsalgo.strings;

import java.util.Arrays;

/**
 * Implement string pattern searching using KMP search
 * 
 */
public class KMPSearch {

	public static void main(String[] args) {

		String text = "ABABDABACDABABCABAB";
		String pattern = "ABAB";

		int[] LPS = new int[pattern.length()];

		/**
		 * computing LPS array
		 */
		computeLPSArray(pattern, LPS);

		System.out.println("LPS: " + Arrays.toString(LPS));

		searchPattern(text, pattern, LPS);
	}

	/**
	 * pattern searching algorithm
	 * 
	 * @param text
	 * @param pattern
	 */
	private static void searchPattern(String text, String pattern, int[] LPS) {

		int i = 0; // for iterating text string
		int j = 0; // for iterating pattern

		while (i < text.length()) {

			if (pattern.charAt(j) == text.charAt(i)) {
				i++;
				j++;
			}

			if (j == pattern.length()) {

				System.out.println("Pattern found at: " + (i - j));
				j = LPS[j - 1];
			} else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {

				if (j != 0) {

					j = LPS[j - 1];
				} else {

					i++;
				}
			}
		}
	}

	/**
	 * Compute temporary array from pattern
	 * 
	 * @param pattern
	 * @param LPS
	 */
	private static void computeLPSArray(String pattern, int[] LPS) {

		int j = 0;
		int i = 1;
		LPS[0] = 0;

		while (i < pattern.length()) {

			/**
			 * 
			 * when characters matches then it means we found a suffix that is also a prefix
			 * so mark the length of it in the LPS array
			 * 
			 */
			if (pattern.charAt(i) == pattern.charAt(j)) {

				j++;
				LPS[i] = j;
				i++;
			} else {

				/**
				 * 
				 * when j is not pointing to that start of the pattern
				 * 
				 */
				if (j != 0) {

					j = LPS[j - 1];
				} else {

					/**
					 * 
					 * when j is pointing to the start of the pattern
					 * 
					 */
					LPS[i] = 0;
					i++;
				}
			}
		}
	}

}
