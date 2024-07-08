package javasamples.multithreading;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(3);

		// Tasks to execute
		List<Task> taskList = Arrays.asList(new Task("task 1"), new Task("task 2"), new Task("task 3"),
				new Task("task 4"), new Task("task 5"), new Task("task 6"), new Task("task 7"), new Task("task 8"),
				new Task("task 9"));

		taskList.forEach((task) -> executor.execute(task));
		executor.shutdown();
	}
}

class Task implements Runnable {
	private String name;

	public Task(String s) {
		name = s;
	}

	// Prints task name and sleeps for 1s
	// This Whole process is repeated 5 times
	@Override
	public void run() {
		try {
			for (int i = 0; i <= 5; i++) {
				if (i == 0) {
					Date d = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
					System.out.println("Initialization Time for" + " task name - " + name + " = " + ft.format(d));
					// prints the initialization time for every task
				} else {
					Date d = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
					System.out.println("Executing Time for task name - " + name + " = " + ft.format(d));
					// prints the execution time for every task
				}
				Thread.sleep(1000);
			}
			System.out.println(name + " complete");
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
