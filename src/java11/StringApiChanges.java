package java11;

public class StringApiChanges {

	public static void main(String[] args) {
		String string = "      ";

		if (string.isBlank()) {
			System.out.println("string is empty");
		}

		String stringWithSpaces = "     gaurav              ";
		System.out.println(stringWithSpaces.strip());
		System.out.println(stringWithSpaces.stripLeading());
		System.out.println(stringWithSpaces.stripTrailing());
	}

}
