package corejava;

import java.util.StringTokenizer;

// This class only accepts type parametes as any class
// which extends class A or class A itself.
// Passing any other type will cause compiler time error

class Bound<T extends A> {

  private T objRef;

  public Bound(T obj) {
    this.objRef = obj;
  }

  public void doRunTest() {
    this.objRef.displayClass();
  }
}


class A {
  public void displayClass() {
    System.out.println("Inside super class A");
  }
}


class B extends A {
  public void displayClass() {
    System.out.println("Inside sub class B");
  }
}


class C extends A {
  public void displayClass() {
    System.out.println("Inside sub class C");
  }
}


public class BoundedType {
  public static void main(String a[]) {

    String mydelim = " : ";
    String mystr = "JAVA : Code : String : Tokenizer : Geeks";

    StringTokenizer geeks3 = new StringTokenizer(mystr, mydelim);
    int count = geeks3.countTokens();
    System.out.println("Number of tokens : " + count + "\n");
    for (int i = 0; i < count; i++)
      System.out.println("token at [" + i + "] : " + geeks3.nextToken());

    while (geeks3.hasMoreTokens())
      System.out.println(geeks3.nextToken());

    // Creating object of sub class C and
    // passing it to Bound as a type parameter.
    Bound<C> bec = new Bound<C>(new C());
    bec.doRunTest();

    // Creating object of sub class B and
    // passing it to Bound as a type parameter.
    Bound<B> beb = new Bound<B>(new B());
    beb.doRunTest();

    // similarly passing super class A
    Bound<A> bea = new Bound<A>(new A());
    bea.doRunTest();

  }
}
