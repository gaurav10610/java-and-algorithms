package strings;

public class RabinKarpPatternSearch {

  // d is the number of characters in the input alphabet
  public final static int d = 256;

  public static void main(String[] args) {
    String string = "ABABDABACDABABCABAB";
    String pattern = "ABA";
    int q = 101; // A prime number
    searchPattern(string, pattern, q);

  }

  private static void searchPattern(String text, String pattern, int q) {
    int M = pattern.length();
    int N = text.length();
    int i, j;
    int p = 0; // hash value for pattern
    int t = 0; // hash value for txt
    int h = 1;
    
    h = (int) (Math.pow(d, M - 1) % q);

    // Calculate the hash value of pattern and first
    // window of text
    for (i = 0; i < M; i++) {
      p = (d * p + pattern.charAt(i)) % q;
      t = (d * t + text.charAt(i)) % q;
    }

    for (i = 0; i < N - M; i++) {

      if (p == t) {

        // Start matching pattern
        for (j = 0; j < M; j++) {
          if (text.charAt(i + j) != pattern.charAt(j)) {
            break;
          }
        }

        if (j == M) {
          System.out.println("Pattern found at: " + i);
        }
      }

      // Calculate hash value for next window of text: Remove
      // leading digit, add trailing digit
      if (i < N - M) {

        t = (d * (t - text.charAt(i) * h) + text.charAt(i + M)) % q;

        // We might get negative value of t, converting it
        // to positive
        if (t < 0)
          t = (t + q);
      }
    }
  }

}
