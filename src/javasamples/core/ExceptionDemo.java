package javasamples.core;

import java.io.Serial;

public class ExceptionDemo {

  public static void main(String[] args) {
    try {
      throw new MyException("This is my custom exception");
    } catch (MyException e) {
      e.printStackTrace();
    }

  }

}


class MyException extends Exception {

  @Serial
  private static final long serialVersionUID = 1L;

  public MyException(String message) {
    super(message);
  }
}
