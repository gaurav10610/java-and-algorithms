package multithreading;

class Line {

	int i;

	public Line(int i) {
		this.i = i;
	}

	public void increment() throws InterruptedException {
		synchronized (this) {
			this.i++;
			System.out.println("Thread " + Thread.currentThread().getName() + " incremented value to: " + this.i);
			notify();
			wait(1000);
		}
	}

	public int getLine() {
		return i;
	}
}

public class MethodSynchronization {

	public static void main(String[] args) {

		Line line = new Line(0);

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 100; i++) {
					try {
						line.increment();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "1");

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 100; i++) {
					try {
						line.increment();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "2");

		t1.start();
		t2.start();
	}
}
