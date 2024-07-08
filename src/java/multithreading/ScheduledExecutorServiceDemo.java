package java.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

	public static void main(String[] args) {

		int timeout = 10;

		TimeOutJobRunnable timeoutJob = new TimeOutJobRunnable(timeout);

		PeriodicJobRunnable recurringJob = new PeriodicJobRunnable(timeout);

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		// scheduling a timeout job
		executor.schedule(timeoutJob, timeout, TimeUnit.SECONDS);

		// scheduling a recurring job
		executor.scheduleAtFixedRate(recurringJob, 0, timeout, TimeUnit.SECONDS);

		try {
			TimeUnit.MILLISECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		executor.shutdown();
	}

}

/**
 * This will run after certain amount of time
 */
class TimeOutJobRunnable implements Runnable {

	private int timeout;

	public TimeOutJobRunnable(int timeout) {
		this.timeout = timeout;
	}

	@Override
	public void run() {

		System.out.println("This is one time scheduled task, executed after " + timeout + " seconds");
	}

}

/**
 * This will run after a fixed interval of time
 */
class PeriodicJobRunnable implements Runnable {

	private int interval;

	public PeriodicJobRunnable(int interval) {
		this.interval = interval;
	}

	@Override
	public void run() {
		System.out.println("This is recurring job, running after every " + interval + " seconds");

	}

}
