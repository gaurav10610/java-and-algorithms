package javasamples.core;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class StringJoinerDemo {

	public static void main(String[] args) {

		String stringObj = new String("Gaurav");
		System.out.println("String value: " + stringObj);

		stringObj = " Kumar";
		System.out.println("String value after modification: " + stringObj);

		// This will modify the String
		// stringObj = stringObj + "Yadav";

		// This won't modify the String
		concat(stringObj, " Yadav");
		System.out.println("String value after concatenation: " + stringObj);

		List<String> list = new ArrayList<String>();
		list.add("Gaurav");
		list.add("Kumar");
		list.add("Yadav");
		list.add("Paras");
		list.add("Yadav");

		StringJoiner sj = new StringJoiner(" : ", "Names Start: ", " :Names Ends");
		sj.setEmptyValue("StringJoiner " + sj.hashCode() + " is empty as of now");
		System.out.println(sj.toString());

		sj.add(list.get(0)).add(list.get(1));
		System.out.println(sj.toString());

		StringJoiner sj1 = new StringJoiner(" : ", "Names Start: ", " :Names Ends");
		sj1.setEmptyValue("StringJoiner " + sj1.hashCode() + " is empty as of now");
		System.out.println(sj1.toString());

		sj1.add(list.get(3)).add(list.get(4));
		System.out.println(sj1.toString());

		sj.merge(sj1);
		System.out.println("StringJoiner " + sj.hashCode() + " after merge.");
		System.out.println(sj.toString());

	}

	public static void concat(String string1, String string2) {
		string1 = string1 + string2;
	}

}
