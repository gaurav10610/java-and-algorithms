package dsalgo.library;

public class PatternSearchingUtils {

  public static void constructDFA(String pattern, int[][] dfa, int totalChars) {

    int state;
    int ascii;
    for (state = 0; state <= pattern.length(); state++) {
      for (ascii = 0; ascii < totalChars; ascii++) {
        dfa[state][ascii] = getNextState(pattern, state, ascii);
      }
    }
  }

  private static int getNextState(String pattern, int state, int ascii) {

    /*
     * If the character c is same as next character in pattern, then simply increment state
     */
    if (state < pattern.length() && ascii == pattern.charAt(state)) {
      return state + 1;
    }

    int ns, i;
    /*
     * ns stores the result which is next state ns finally contains the longest prefix which is also
     * suffix in "pat[0..state-1]c" Start from the largest possible value and stop when you find a
     * prefix which is also suffix
     */
    for (ns = state; ns > 0; ns--) {
      if (pattern.charAt(ns - 1) == ascii) {
        for (i = 0; i < ns - 1; i++) {
          if (pattern.charAt(i) != pattern.charAt(state - ns + 1 + i))
            break;
        }
        if (i == ns - 1)
          return ns;
      }
    }
    return 0;
  }
}
