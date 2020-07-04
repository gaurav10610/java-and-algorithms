package multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorDemo {

  public static void main(String[] args) {

    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
    executor.execute(new RunnableTask());
    executor.shutdown();
  }
}

class RunnableTask implements Runnable {

  @Override
  public void run() {
    System.out.println("This is runnable job");
  }


}
