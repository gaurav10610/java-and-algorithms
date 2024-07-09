package javasamples.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayNListConversion {
    public static void main(String[] args) {

        /*
         * list to primitive int array
         */
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int[] intArray = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("int array: " + Arrays.toString(intArray));

        /*
         * primitive int array to list
         */
        List<Integer> intList = IntStream.of(intArray).boxed().toList();
        System.out.print("int list: " + intList);
    }
}
