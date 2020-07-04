package multithreading;

import java.util.Scanner;

public class ThreadCommunication {

  public static void main(String[] args) {
    final ProducerConsumer pc = new ProducerConsumer();

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


class ProducerConsumer {

  public void produce() throws InterruptedException {


    synchronized (this) {
      System.out.println("Producer has done producing.");

      wait();
      System.out.println("Producer has resumed producing.");
    }
  }

  public void consume() throws InterruptedException {

    synchronized (this) {

      Thread.sleep(3000);
      Scanner sc = new Scanner(System.in);
      System.out.println("Consumer is waiting for return key.");
      sc.nextLine();
      System.out.println("Return key has been pressed");

      notify();
      Thread.sleep(3000);
    }
  }
}
