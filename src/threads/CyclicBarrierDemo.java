package threads;

import java.util.concurrent.BrokenBarrierException;

public class CyclicBarrierDemo extends Thread {

  static java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(4);

  public static void main(String[] args) {
    CyclicBarrierDemo thread = new CyclicBarrierDemo();
    thread.start();

  }

  public void run() {
    System.out.println("No. of threads waiting for brarrier to trip: " + barrier.getParties());

    Thread1 thread1 = new Thread1();
    Thread2 thread2 = new Thread2();
    Thread3 thread3 = new Thread3();

    Thread t1 = new Thread(thread1);
    Thread t2 = new Thread(thread2);
    Thread t3 = new Thread(thread3);

    t1.start();
    t2.start();
    t3.start();

    try {
      barrier.await();
    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }

    if (barrier.getNumberWaiting() == 0) {
      System.out.println("Barrier is broken.");
    }
    
    int sum = Thread1.product + Thread2.product + Thread3.product;
    System.out.print("Sum is: " + sum);
  }

}


class Thread1 implements Runnable {

  static int product = 0;

  @Override
  public void run() {
    product = 1;
    try {
      CyclicBarrierDemo.barrier.await();
    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }
  }

}


class Thread2 implements Runnable {

  static int product = 0;

  @Override
  public void run() {
    product = 2;
    try {
      CyclicBarrierDemo.barrier.await();
    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }
  }

}


class Thread3 implements Runnable {

  static int product = 0;

  @Override
  public void run() {
    product = 3;
    try {
      CyclicBarrierDemo.barrier.await();
    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }
  }

}
