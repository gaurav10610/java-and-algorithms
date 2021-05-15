package corejava;

public class PassByValue {

  public static void main(String[] args) {
    Test t = new Test(5);
    System.out.println("Value before modification: " + t.x);
    changeValue(t);
    System.out.println("Value after modification: " + t.x);
  }

  public static void changeValue(Test t) {
    t = new Test();
    t.x = 10;
  }

}


class Test {

  int x;

  Test(int x) {
    this.x = x;
  }

  Test() {
    this.x = 0;
  }
}
