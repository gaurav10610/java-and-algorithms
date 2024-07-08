package javasamples.core;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UtilsDemo {

    public static void main(String[] args) {
        int[] array = {97, 46, 37, 12, 3, 7, 31, 6, 9};

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        Map<Integer, String> map = new HashMap<Integer, String>();
        IntStream.rangeClosed(1, 7).forEach(i -> map.put(i, "gaurav" + i));

        List<String> list = map.entrySet().stream()
                .filter(entry -> entry.getKey().equals(1) || entry.getKey().equals(4))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
