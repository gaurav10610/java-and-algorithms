package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		FutureTask<?>[] futureTasks = new FutureTask<?>[5];

		for (int i = 0; i < 5; i++) {
			futureTasks[i] = new FutureTask<Integer>(new CallableTask());
			Thread t = new Thread(futureTasks[i]);
			t.start();
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("Value of result[" + i + "] = " + futureTasks[i].get());
		}
	}

}

class CallableTask implements Callable<Integer> {

	static int value = 0;

	@Override
	public Integer call() throws Exception {
		return ++value;
	}

}
