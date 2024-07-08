package javasamples.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedArrayListDemo extends Thread {

  static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
//  static List<String> list = new ArrayList<>();

  @Override
  public void run() {
    list.add("Himanshu");
    list.add("Gaurav");
    list.add("Paras");
    list.add("Suman");
    list.add("Prabhat");
  }

  public static void main(String[] args) throws InterruptedException {

//    list = Collections.synchronizedList(list);

    SynchronizedArrayListDemo thread1 = new SynchronizedArrayListDemo();
    thread1.start();

    SynchronizedArrayListDemo thread2 = new SynchronizedArrayListDemo();
    thread2.start();

    SynchronizedArrayListDemo thread3 = new SynchronizedArrayListDemo();
    thread3.start();

    System.out.printf("Below is the list: %s\n", list);
    System.out.printf("final list size: %d", list.size());
  }

}
