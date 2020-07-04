package multithreading;

import java.util.Stack;
import java.util.concurrent.Semaphore;

public class ProducerConsumerUsingSemaphore {

  public static void main(String[] args) {

    Semaphore semaphore = new Semaphore(1);
    ProduceConsumeFactory factory = new ProduceConsumeFactory(semaphore);

    Thread thread1 = new Thread(new Runnable() {

      @Override
      public void run() {
        try {
          factory.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
    });

    Thread thread2 = new Thread(new Runnable() {

      @Override
      public void run() {
        try {
          factory.consume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    thread1.start();
    thread2.start();
  }

}


class ProduceConsumeFactory {

  private Stack<Integer> stack;
  private Semaphore semaphore;
  private int count;

  public ProduceConsumeFactory(Semaphore semaphore) {
    this.semaphore = semaphore;
    this.count = 0;
    this.stack = new Stack<Integer>();
  }

  public void produce() throws InterruptedException {

    while (true) {

      semaphore.acquire();
      stack.push(++count);
      System.out.println("Produced " + count + " in stack");
      semaphore.release();
      Thread.sleep(500);
    }
  }

  public void consume() throws InterruptedException {

    Thread.sleep(500);
    while (true) {
      semaphore.acquire();
      System.out.println("Consumed " + stack.pop() + " from stack");
      semaphore.release();
      Thread.sleep(500);
    }
  }
}
