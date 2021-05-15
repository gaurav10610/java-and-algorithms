package corejava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedArrayList extends Thread {

  static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
//  static List<String> list = new ArrayList<String>();

  @Override
  public void run() {
    list.add("Himanshu");
    list.add("Gaurav");
    list.add("Paras");
    list.add("Suman");
    list.add("Prabhat");
  }

  public static void main(String[] args) throws InterruptedException {
    list.add("Gaurav");
    list.add("Paras");
    list.add("Suman");
    list.add("Prabhat");

    SynchronizedArrayList thread1 = new SynchronizedArrayList();
    thread1.start();
    SynchronizedArrayList thread2 = new SynchronizedArrayList();
    thread2.start();
    SynchronizedArrayList thread3 = new SynchronizedArrayList();
    thread3.start();
//    Thread.sleep(1000);

    System.out.println("Below is the list: ");

    list.forEach(element -> {
      System.out.print(" " + element);
//      try {
//        Thread.sleep(1000);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
    });
  }

}
