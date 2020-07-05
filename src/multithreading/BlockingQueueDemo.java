package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

  public static void main(String[] args) {

    ProducerConsumerFactory producerConsumerFactory = new ProducerConsumerFactory(1);

    Thread thread1 = new Thread(new Runnable() {

      @Override
      public void run() {

        try {

          // produce in queue
          producerConsumerFactory.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread thread2 = new Thread(new Runnable() {

      @Override
      public void run() {

        try {

          // consume from queue
          producerConsumerFactory.consume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    thread1.start();
    thread2.start();

  }
}


class ProducerConsumerFactory {

  private BlockingQueue<Integer> queue;
  private int count;

  public ProducerConsumerFactory(int capacity) {
    this.queue = new ArrayBlockingQueue<Integer>(capacity);
    this.count = 0;
  }

  public void produce() throws InterruptedException {

    while (true) {
      queue.put(++count);
      System.out.println("Produced " + count + " in queue");
      TimeUnit.MILLISECONDS.sleep(1000);
    }
  }

  public void consume() throws InterruptedException {

    while (true) {
      System.out.println("Consumed " + queue.take() + " from queue");
      TimeUnit.MILLISECONDS.sleep(500);
    }
  }
}
