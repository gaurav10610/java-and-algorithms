package java12;

import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.Locale;
import library.ConsoleUtils;

public class CompactNumberFormatterDemo {

	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US, Style.SHORT);

		long number = 45006700899L;
		String compactNumber = formatter.format(number);
		System.out.printf("%d in compact form is %s", number, compactNumber);

		ConsoleUtils.addNewLine();

		long number1 = 450098L;
		String compactNumber1 = formatter.format(number1);
		System.out.printf("%d in compact form is %s", number1, compactNumber1);
	}

}
