package corejava;

public class CopyConstructor {

  public static void main(String[] args) {
    ClassA obj = new ClassA(10, 20);

    ClassA copiedObj = new ClassA(obj);
    System.out.println("Copied value of a: " + copiedObj.a);
    System.out.println("Copied value of b: " + copiedObj.b);
  }

}


class ClassA {
  int a;
  int b;

  ClassA(int a, int b) {
    this.a = a;
    this.b = b;
  }

  //Copy constructor
  ClassA(ClassA obj) {
    this.a = obj.a;
    this.b = obj.b;
  }
}
