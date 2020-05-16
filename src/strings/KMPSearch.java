package strings;

public class KMPSearch {

  public static void main(String[] args) {

    String text = "ABABDABACDABABCABAB";
    String pattern = "ABA";
    searchPattern(text, pattern);
  }

  /**
   * pattern searching algorithm
   * 
   * @param text
   * @param pattern
   */
  private static void searchPattern(String text, String pattern) {

    int[] lps = new int[pattern.length()];

    /**
     * computing lps array
     */
    computeLPSArray(pattern, lps);

    int i = 0; // for iterating text string
    int j = 0; // for iterating pattern

    while (i < text.length()) {

      if (text.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      }

      // pattern found
      if (j == pattern.length()) {

        System.out.println("pattern found at index: " + (i - j));
        j = lps[j - 1];
      } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {

        // characters not matched after j matches
        if (j != 0) {

          // if j is not pointing to start position i.e 0th index
          j = lps[j - 1];
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
   * @param lps
   */
  private static void computeLPSArray(String pattern, int[] lps) {

    int j = 0;
    int i = 1;
    lps[0] = 0;

    while (i < pattern.length()) {

      // when charcters match
      if (pattern.charAt(j) == pattern.charAt(i)) {

        j++;
        lps[i] = j;
        i++;
      } else {

        // if j is not pointing to start position i.e 0th index
        if (j != 0) {

          j = lps[j - 1];
        } else {

          lps[i] = 0;
          i++;
        }

      }
    }
  }

}
