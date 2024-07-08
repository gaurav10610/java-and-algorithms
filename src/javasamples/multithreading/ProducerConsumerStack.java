package javasamples.multithreading;

import java.util.Stack;

public class ProducerConsumerStack {

	public static void main(String[] args) throws InterruptedException {
		final ProduceConsume pc = new ProduceConsume();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
	}

}

class ProduceConsume {

	private Stack<Integer> numbers;
	private Integer capacity;

	public ProduceConsume() {
		numbers = new Stack<Integer>();
		capacity = 2;
	}

	public void produce() throws InterruptedException {

		int value = 0;
		while (true) {
			synchronized (this) {
				if (numbers.size() == capacity) {
					wait();
				}
				numbers.push(++value);
				System.out.println("Produced " + value + " in stack");
				notify();
				Thread.sleep(1000);
			}
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (numbers.size() == 0) {
					wait();
				}
				Integer number = numbers.pop();
				System.out.println("Consumed " + number + " from stack.");
				notify();
				Thread.sleep(1000);
			}
		}
	}
}
