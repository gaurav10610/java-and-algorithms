package strings;

public class KMPSearch {

  public static void main(String[] args) {

    String string = "ABABDABACDABABCABAB";
    String pattern = "ABA";
    searchPattern(string, pattern);
  }

  private static void searchPattern(String string, String pattern) {

    int[] lps = new int[pattern.length()];
    computeLPSArray(pattern, lps);
    int i = 0; // For string
    int j = 0; // For pattern

    while (i < string.length()) {

      if (string.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      }

      if (j == pattern.length()) {
        System.out.println("Pattern found at: " + (i - j));
        j = lps[j - 1];
      }

      else if (i < string.length() && string.charAt(i) != pattern.charAt(j)) {

        if (j != 0) {

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

    // Previous longest prefix length
    int longestPrefixLength = 0;
    int i = 1;
    lps[0] = 0;

    while (i < pattern.length()) {

      if (pattern.charAt(i) == pattern.charAt(longestPrefixLength)) {
        longestPrefixLength++;
        lps[i] = longestPrefixLength;
        i++;
      } else { // pattern.charAt(i) != pattern.charAt(longestPrefixLength)

        if (longestPrefixLength != 0) {

          longestPrefixLength = lps[longestPrefixLength - 1];
          // Also, note that we do not increment
          // i here
        } else { // if (longestPrefixLength == 0)

          lps[i] = longestPrefixLength;
          i++;
        }
      }
    }

  }

}
