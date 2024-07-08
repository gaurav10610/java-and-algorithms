package dsalgo.common;

public class SwapStrings {

	public static void main(String[] args) {
		String string1 = "Gaurav Kumar Yadav";
		String string2 = "Prabhat Mishra";

		string1 = string1 + string2;
		string2 = string1.substring(0, (string1.length() - string2.length()));
		string1 = string1.substring(string2.length());
		System.out.println("String1: " + string1);
		System.out.println("String2: " + string2);
	}

}
