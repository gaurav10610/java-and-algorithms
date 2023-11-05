package corejava;

public class ChainedException {

	public static void main(String[] args) {
		try {
			ArithmeticException except = new ArithmeticException("This is arithmetic exception");

			except.initCause(new NullPointerException());
			throw except;
		} catch (ArithmeticException e) {
			e.getCause().printStackTrace();
		}
	}

}
