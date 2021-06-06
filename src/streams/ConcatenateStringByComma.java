package streams;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * ("abc", "", "bc", "efg", "abcd","", "jkl")
 * 
 * concatenate all the non empty strings by comma and print the result
 *
 */
public class ConcatenateStringByComma {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
    String resultString = list.stream().filter((string) -> string.length() > 0)
        .reduce((string1, string2) -> string1 + "," + string2).get();
    System.out.println(resultString);
    
    String stringSeparatedByPipe = list.stream().filter(string -> string.length() > 0)
        .reduce((string1, string2) -> string1 + "||" + string2).get();
    System.out.println(stringSeparatedByPipe);
  }

}
