package corejava;

public class DependencyInjection {

  public static void main(String[] args) {
    BaseInterface obj1 = new Temp1();
    BaseInterface obj2 = new Temp2();
    TestClass test = new TestClass(obj1);
    
    test.getObj().doSomething();
    
    test = new TestClass(obj2);

    test.getObj().doSomething();
  }

}


class TestClass {
  
  BaseInterface obj;

  public TestClass(BaseInterface obj) {
    this.obj = obj;
  }

  public BaseInterface getObj() {
    return obj;
  }

  public void setObj(BaseInterface obj) {
    this.obj = obj;
  }
}


interface BaseInterface {
  public void doSomething();
}


class Temp1 implements BaseInterface {

  @Override
  public void doSomething() {
    System.out.println("This is class A");
  }

}


class Temp2 implements BaseInterface {

  @Override
  public void doSomething() {
    System.out.println("This is class B");
  }

}
