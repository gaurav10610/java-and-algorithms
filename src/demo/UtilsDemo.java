package demo;

import java.util.*;
import java.util.stream.*;

public class UtilsDemo {

	public static void main(String[] args) {
		int[] array = { 97, 46, 37, 12, 3, 7, 31, 6, 9 };

		Arrays.sort(array);
		System.out.println(Arrays.toString(array));

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "gaurav");
		map.put(2, "gaurav2");
		map.put(3, "gaurav3");
		map.put(4, "gaurav4");
		map.put(5, "gaurav5");
		map.put(6, "gaurav6");
		map.put(7, "gaurav7");

		List<String> list = map.entrySet().stream()
				.filter(entry -> entry.getKey().equals(1) || entry.getKey().equals(4)).map(entry -> entry.getValue())
				.collect(Collectors.toList());
		System.out.println(list.toString());
	}
}
