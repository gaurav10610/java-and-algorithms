package javasamples.core;

import java.util.*;

public class MapIterator {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "gaurav");
		map.put(2, "gaurav");
		map.put(3, "gaurav");
		map.put(4, "gaurav");
		map.put(5, "gaurav");
		map.put(6, "gaurav");
		map.put(7, "gaurav");

		map.forEach((key, value) -> {
			System.out.println("key: " + key + " " + "value: " + value);
		});

		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("key: " + entry.getKey() + " " + "value: " + entry.getValue());
		}
	}

}
