package multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class FactorialUsingCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

		Map<Integer, Future<Integer>> results = new HashMap<>();

		for (int i = 2; i < 6; i++) {

			FactorialCalculator factCal = new FactorialCalculator(i);

			Future<Integer> futureTask = executor.submit(factCal);
			results.put(i, futureTask);
		}

		for (Map.Entry<Integer, Future<Integer>> entry : results.entrySet()) {
			System.out.println("Factorial of " + entry.getKey() + " is: " + entry.getValue().get());
		}

		executor.shutdown();
	}
}

class FactorialCalculator implements Callable<Integer> {

	private int number;

	public FactorialCalculator(int number) {
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {

		if (number == 0) {
			return 1;
		} else {

			int fact = 1;
			while (number > 0) {
				fact = fact * number;
				number--;
			}
			return fact;
		}
	}

}
