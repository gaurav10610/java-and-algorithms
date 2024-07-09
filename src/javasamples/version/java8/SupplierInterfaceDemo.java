package javasamples.version.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierInterfaceDemo {

	/**
	 * consumer for printing each element of list
	 */
	private final static Consumer<List<Integer>> printList = System.out::print;

	/**
	 * supplier for supplying the list
	 */
	static Supplier<List<Integer>> supplyList = () -> Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

	public static void main(String[] args) {
		printList.accept(supplyList.get());
	}

}
