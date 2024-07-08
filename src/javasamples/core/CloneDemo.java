package javasamples.core;

public class CloneDemo {

  public static void main(String[] args) throws CloneNotSupportedException {
    TestClone obj1 = new TestClone();
    obj1.a = 10;
    obj1.b = 20;

    TestClone cloneObj = (TestClone) obj1.clone();
    System.out.println("Clone value of a: " + cloneObj.a);
    System.out.println("Clone value of b: " + cloneObj.b);

  }

}


class TestClone implements Cloneable {

  int a;
  int b;

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();

  }
}
