package javasamples.version.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {

    public static void main(String[] args) {
        String numbers = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16";

        StringBuilder sb = new StringBuilder();
        Arrays.stream(numbers.split(" "))
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .map(Object::toString)
                .forEach(num -> sb.append(" ").append(num));

        System.out.println("All the even numbers: " + sb);

        String finalString = Arrays.stream(numbers.split(" "))
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .map(Object::toString)
                .reduce("", (num, value) -> String.join(",", num, value));

        System.out.println("All the even numbers are: " + finalString);

        Integer evenSum = Arrays.stream(numbers.split(" "))
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .reduce(0, Math::addExact);

        System.out.println("Sum of even numbers is: " + evenSum);

        Integer allSum = Arrays.stream(numbers.split(" "))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);

        System.out.println("Sum of all the numbers is: " + allSum);
    }
}
