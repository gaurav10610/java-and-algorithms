package java.multithreading;

import java.util.Arrays;
import java.util.List;

public class PrintEvenOdd {

	public static void main(String[] args) {
		final PrintSeries pc = new PrintSeries();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.printEven();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				pc.printOdd();
			}
		});

		t1.setName("Thread 1");
		t2.setName("Thread 2");
		
		t1.start();
		t2.start();
	}
}

class PrintSeries {

	List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

	public void printEven() throws InterruptedException {

		Thread.sleep(500);
		synchronized (this) {
			list.stream().filter((number) -> number % 2 == 0).forEach((number) -> {
				System.out.println(Thread.currentThread().getName() + ": " + number);
				try {
					notify();
					wait(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
	}

	public void printOdd() {
		synchronized (this) {
			list.stream().filter((number) -> number % 2 != 0).forEach((number) -> {
				System.out.println(Thread.currentThread().getName() + ": " + number);
				try {
					notify();
					wait(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
	}
}
