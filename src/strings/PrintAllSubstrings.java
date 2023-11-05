package strings;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Print all substrings of a string
 * 
 */
public class PrintAllSubstrings {

	public static void main(String[] args) {
		String string = "abbc";
		List<String> substringsList = printSubstrings(string);
		System.out.print(substringsList);
	}

	public static List<String> printSubstrings(String string) {

		List<String> substringsList = new ArrayList<>();

		for (int substringLength = 1; substringLength <= string.length(); substringLength++) {

			int substringStartIndex = 0;
			while (substringStartIndex + substringLength <= string.length()) {
				substringsList.add(string.substring(substringStartIndex, substringStartIndex + substringLength));
				substringStartIndex++;
			}
		}
		return substringsList;
	}
}
