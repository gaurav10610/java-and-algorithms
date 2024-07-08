package java.version.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);

		StringBuilder sb = new StringBuilder("");
		numbers.stream().filter(num -> num % 2 == 0).map(num -> num.toString()).map(num -> sb.append(" " + num))
				.collect(Collectors.toList());
		System.out.println("All the even numbers: " + sb.toString());

		System.out.println("All the even numbers are: " + numbers.stream().filter(num -> num % 2 == 0)
				.map(num -> num.toString()).reduce("", (num, value) -> String.join(",", num, value)));

		System.out.println("Sum of even numbers is: "
				+ numbers.stream().filter(num -> num % 2 == 0).reduce(0, (num, value) -> Math.addExact(num, value)));

		System.out.println("Sum of all the numbers is: " + numbers.stream().reduce(0, Integer::sum));
	}
}
