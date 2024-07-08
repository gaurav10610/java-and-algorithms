package java.version.java8;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalDemo {

	public static void main(String[] args) {
		String name = "Gaurav Kumar Yadav";
		Optional<String> nameOptional = Optional.ofNullable(name);

		nameOptional.ifPresent(nameValue -> System.out.println("Name optional contains value => " + nameValue));

		nameOptional = Optional.empty();

		nameOptional.ifPresentOrElse(nameValue -> System.out.println("Name => " + nameValue),
				() -> System.out.println("Name optional contains null value"));

		Supplier<String> defaultValueSupplier = () -> "Default Name";

		String optionalValue = (String) Optional.ofNullable(null).orElseGet(defaultValueSupplier);

		System.out.println("Name optional contains value => " + optionalValue);

		Integer number = 15;
		Optional<Integer> numberOptional = Optional.of(number);

		numberOptional.filter(numValue -> numValue > 10).filter(numValue -> numValue < 20).ifPresentOrElse(
				(numValue) -> System.out.println("Number optional is present within range => " + numValue),
				() -> System.out.println("Number optional within range is not present and is empty"));
	}

}
