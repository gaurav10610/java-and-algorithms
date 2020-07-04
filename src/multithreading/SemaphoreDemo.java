package multithreading;

import java.util.concurrent.Semaphore;

class ShareResource {
  public static int count = 0;
}


public class SemaphoreDemo {

  public static void main(String[] args) throws InterruptedException {
    Semaphore semaphore = new Semaphore(1);
    ThreadClass t1 = new ThreadClass(semaphore, "A");
    ThreadClass t2 = new ThreadClass(semaphore, "B");

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    // count will always remain 0 after
    // both threads will complete their execution
    System.out.println("count: " + ShareResource.count);
  }


}


class ThreadClass extends Thread {

  Semaphore semaphore;
  String name;

  ThreadClass(Semaphore semaphore, String name) {
    this.semaphore = semaphore;
    this.name = name;
  }

  @Override
  public void run() {

    if (name.equals("A")) {

      for (int i = 0; i < 5; i++) {
        try {
          semaphore.acquire();

          System.out.println("Thread " + name + " got access on shared resource.");
          ShareResource.count++;

          System.out.println("Value of shared  resouce: " + ShareResource.count);
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("Thread " + name + " releasing  lock");
        semaphore.release();
      }

    } else {
      for (int i = 0; i < 5; i++) {
        try {
          semaphore.acquire();

          System.out.println("Thread " + name + " got access on shared resource.");
          ShareResource.count--;

          System.out.println("Value of shared  resouce: " + ShareResource.count);
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("Thread " + name + " releasing  lock");
        semaphore.release();
      }
    }
  }
}
