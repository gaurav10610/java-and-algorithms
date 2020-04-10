package threads;

class ThreadJoin extends Thread {

  public ThreadJoin(String name) {
    super(name);
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(500);
        System.out.println("Current Thread: " + Thread.currentThread().getName());
      }

      catch (Exception ex) {
        System.out.println("Exception has" + " been caught" + ex);
      }
    }
  }
}


public class JoinDemo {

  public static void main(String[] args) throws InterruptedException {
    ThreadJoin t1 = new ThreadJoin("1");
    ThreadJoin t2 = new ThreadJoin("2");
    ThreadJoin t3 = new ThreadJoin("3");

    t1.start();
    // starts second thread after when
    // first thread t1 is died.
    t1.join();

    // t2 starts
    t2.start();

    // starts t3 after when thread t2 is died.
    t2.join();

    t3.start();
    t3.join();
    System.out.print("Main has finished executing.");
  }
}
