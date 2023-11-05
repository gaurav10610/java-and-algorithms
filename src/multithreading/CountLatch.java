package multithreading;

import java.util.concurrent.CountDownLatch;

public class CountLatch {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch latch = new CountDownLatch(3);

		Worker runnable1 = new Worker("1", latch);
		Worker runnable2 = new Worker("2", latch);
		Worker runnable3 = new Worker("3", latch);
		
		Thread t1 = new Thread(runnable1);
		Thread t2 = new Thread(runnable2);
		Thread t3 = new Thread(runnable3);

		t1.start();
		t2.start();
		t3.start();

		latch.await();
		System.out.println("Current Thread: " + Thread.currentThread().getName());

	}

}

// Worker thread
class Worker implements Runnable {

	private CountDownLatch latch;
	private String name;

	public Worker(String name, CountDownLatch latch) {
		this.name = name;
		this.latch = latch;
	}

	public String getName() {
		return name;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			System.out.println("Current Thread: " + Thread.currentThread().getName());
			latch.countDown();
		} catch (Exception ex) {
			System.out.println("Exception has" + " been caught" + ex);
		}
	}
}
