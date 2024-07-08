package javasamples.streams;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * evaluate sum of given numbers
 *
 */
public class SumOfNaturalNumbers {

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		int sum = integers.stream().reduce(0, Integer::sum);
		System.out.println("sum of given numbers: " + sum);

		List<String> numList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
		System.out.println("maximum: " + numList.stream().mapToInt(Integer::parseInt).max().getAsInt());
		System.out.println("minimum: " + numList.stream().mapToInt(Integer::parseInt).min().getAsInt());
	}

}
