package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AnagramSubStrings {

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {

      String q = br.readLine();
      int count = 0;

      for (int k = q.length() - 1; k > 0; k--) {

        List<String> subStrings = getSubStrings(q, k);
        for (int p = 0; p < subStrings.size() - 1; p++) {

          for (int z = p + 1; z < subStrings.size(); z++) {

            // Check anagram or not
            if (isAnagram(subStrings.get(p), subStrings.get(z))) {
              count++;
            }
          }
        }
      }
      System.out.println(count);
    }
  }

  // Get All substrings of specified length
  public static List<String> getSubStrings(String string, int length) {
    List<String> list = new ArrayList<String>();
    int inputLength = string.length();
    int startIndex = 0;
    int endIndex = startIndex + length;
    while (endIndex <= inputLength) {
      list.add(string.substring(startIndex, endIndex));
      startIndex++;
      endIndex = startIndex + length;
    }
    return list;
  }

  // Return whether anagram or not
  public static boolean isAnagram(String string1, String string2) {

    int[] arr = new int[256];

    for (int i = 0; i < string1.length(); i++) {
      arr[(int) string1.charAt(i)]++;
    }

    for (int k = 0; k < string2.length(); k++) {
      arr[(int) string2.charAt(k)]--;
    }

    for (int s = 97; s < 123; s++) {
      if (arr[s] != 0)
        return false;
    }
    return true;
  }

}
