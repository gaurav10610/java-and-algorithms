package javasamples.version.java8;

import java.util.function.Predicate;

public class PredicateInterfaceDemo {

	public static void main(String[] args) {
		String name = "Gaurav Kumar Yadav";
		String name1 = "Gaurav Kumar";

		Predicate<String> haveMinLength = string -> string.length() > 5;

		Predicate<String> isFullName = string -> string.split(" ").length >= 3;

		System.out.println("Is " + name + " a valid name: " + haveMinLength.and(isFullName).test(name));
		System.out.println("Is " + name1 + " a valid name: " + haveMinLength.and(isFullName).test(name1));
	}

}
