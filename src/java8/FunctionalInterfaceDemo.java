package java8;

@FunctionalInterface
interface Operator<T> {
	T process(T a, T b);
}

public class FunctionalInterfaceDemo {
	public static void main(String[] args) {

		Operator<Integer> addOpertaion = (a, b) -> a + b;
		Operator<Integer> multiplyOperation = (a, b) -> a * b;

		System.out.printf("add operation result of (2,5) => %d", addOpertaion.process(2, 5));
		System.out.println();
		System.out.printf("multiply operation result of (2,5) => %d", multiplyOperation.process(2, 5));
	}
}
