package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

		Optional<String> resultString = list.stream().filter((string) -> string.length() > 0)
				.reduce((string1, string2) -> string1 + "," + string2);

		resultString.ifPresent((result) -> System.out.println(result));

		Optional<String> stringSeparatedByPipe = list.stream().filter(string -> string.length() > 0)
				.reduce((string1, string2) -> string1 + "||" + string2);

		stringSeparatedByPipe.ifPresent((result) -> System.out.println(result));

		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		Optional<Integer> sum = numberList.stream().reduce((num1, num2) -> num1 + num2);

		System.out.printf("sum of list %s is: %d ", Arrays.deepToString(numberList.toArray()), sum.get());
	}

}
