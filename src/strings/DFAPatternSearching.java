package strings;

import library.PatternSearchingUtils;

public class DFAPatternSearching {

  public static void main(String[] args) {
    int total_characters = 256;
    String string = "ABABDABACDABABCABAB";
    String pattern = "ABA";
    int[][] dfa = new int[pattern.length() + 1][total_characters];
    PatternSearchingUtils.constructDFA(pattern, dfa, total_characters);
    // ArrayUtils.printInt2DArray(dfa);
    searchPattern(string, pattern, dfa);
  }

  public static void searchPattern(String string, String pattern, int[][] dfa) {

    int i, state = 0;
    for (i = 0; i < string.length(); i++) {
      state = dfa[state][string.charAt(i)];
      if (state == pattern.length()) {
        System.out.println("Pattern found at " + (i - pattern.length() + 1));
      }
    }
  }

}
