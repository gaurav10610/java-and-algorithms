package javasamples.core;


import java.util.HashMap;
import java.util.Map;

public class MapIterator {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 1; i <= 7; i++) {
            map.put(i, "gaurav");
        }

        map.forEach((key, value) -> {
            System.out.printf("{key: %d, value: %s} \n", key, value);
        });

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.printf("{key: %d, value: %s} \n", entry.getKey(), entry.getValue());
        }
    }

}
