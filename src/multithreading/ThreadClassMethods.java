package multithreading;

public class ThreadClassMethods implements Runnable {

	@Override
	public void run() {
		System.out.println("this is thread class method");

	}

	public static void main(String[] args) {

		ThreadClassMethods threadInstance = new ThreadClassMethods();
		Helper obj2 = new Helper();

		Thread thread1 = new Thread(threadInstance);
		Thread thread2 = new Thread(obj2);

		// moving thread to runnable states
		thread1.start();
		thread2.start();

		thread1.getContextClassLoader();
		new Thread(new Helper());

		// getting number of active threads
		System.out.println(Thread.activeCount());

		// fetching an instance of this thread
		Thread t = Thread.currentThread();

		System.out.println(t.getName());

		System.out.println("Thread1 name: " + thread1.getName());
		System.out.println("Thread1 ID: " + thread1.getId());

		// fetching the priority and state of thread1
		System.out.println("Priority of thread1 = " + thread1.getPriority());

		System.out.println(thread1.getState());

		thread2 = new Thread(obj2);
		thread2.start();
		thread2.interrupt();
		System.out.println("Is thread2 interrupted? " + Thread.interrupted());
		System.out.println("Is thread2 alive? " + thread2.isAlive());

		thread1 = new Thread(threadInstance);
		thread1.setDaemon(true);
		System.out.println("Is thread1 a daemon thread? " + thread1.isDaemon());
		System.out.println("Is thread1 interrupted? " + thread1.isInterrupted());

		// waiting for thread2 to complete its execution
		System.out.println("thread1 waiting for thread2 to join");
		try {
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// setting the name of thread1
		thread1.setName("child thread xyz");
		System.out.println("New name set for thread 1" + thread1.getName());

		// setting the priority of thread1
		thread1.setPriority(5);

		Thread.yield();

		// fetching the string representation of thread1
		System.out.println(thread1.toString());

		// getting list of active thread in current thread's group
		Thread[] tarray = new Thread[3];

		Thread.enumerate(tarray);
		System.out.println("List of active threads:");
		System.out.printf("[");
		for (Thread thread : tarray) {
			System.out.println(thread);
		}
		System.out.printf("]\n");

		System.out.println(Thread.getAllStackTraces());

		ClassLoader classLoader = thread1.getContextClassLoader();
		System.out.println(classLoader.toString());
		System.out.println(Thread.getDefaultUncaughtExceptionHandler());

		thread2.setUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
		thread1.setContextClassLoader(thread2.getContextClassLoader());
		Thread.setDefaultUncaughtExceptionHandler(thread2.getUncaughtExceptionHandler());

		thread1 = new Thread(threadInstance);
		StackTraceElement[] trace = thread1.getStackTrace();
		System.out.println("Printing stack trace elements for thread1:");
		for (StackTraceElement e : trace) {
			System.out.println(e);
		}

		ThreadGroup grp = thread1.getThreadGroup();
		System.out.println("ThreadGroup to which thread1 belongs " + grp.toString());
		System.out.println(thread1.getUncaughtExceptionHandler());
		System.out.println("Does thread1 holds Lock? " + Thread.holdsLock(obj2));

		Thread.dumpStack();
	}

}

class Helper implements Runnable {
	public void run() {
		try {
			System.out.println("thread2 going to sleep for 5000");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Thread2 interrupted");
		}
	}
}
