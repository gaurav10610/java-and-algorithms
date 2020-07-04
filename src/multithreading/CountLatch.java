package multithreading;

import java.util.concurrent.CountDownLatch;

public class CountLatch {

  public static void main(String[] args) throws InterruptedException {

    CountDownLatch latch = new CountDownLatch(3);

    Worker t1 = new Worker("1", latch);
    Worker t2 = new Worker("2", latch);
    Worker t3 = new Worker("3", latch);

    t1.start();
    t2.start();
    t3.start();
    
    latch.await();
    System.out.println("Current Thread: " + Thread.currentThread().getName());

  }

}


// Worker thread
class Worker extends Thread {

  CountDownLatch latch;

  public Worker(String name, CountDownLatch latch) {
    super(name);
    this.latch = latch;
  }

  @Override
  public void run() {
      try {
        Thread.sleep(500);
        System.out.println("Current Thread: " + Thread.currentThread().getName());
        latch.countDown();
      }
      catch (Exception ex) {
        System.out.println("Exception has" + " been caught" + ex);
      }
    }
  }
