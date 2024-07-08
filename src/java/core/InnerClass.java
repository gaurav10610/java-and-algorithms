package java.core;

class OuterClass {

  static class StaticClass {
    
    public void display() {
      System.out.println("This is static inner class.");
    }
  }

  class NonStaticClass {

    public void display() {
      System.out.println("This is not static inner class.");
    }
  }
}


public class InnerClass {

  public static void main(String[] args) {
    OuterClass.StaticClass staticObj = new OuterClass.StaticClass();
    staticObj.display();
    
    OuterClass outer = new OuterClass();
    OuterClass.NonStaticClass nonStaticObj = outer.new NonStaticClass(); 
    nonStaticObj.display();
  }

}
