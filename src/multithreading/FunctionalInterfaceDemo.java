package multithreading;

public class FunctionalInterfaceDemo {

  public static void main(String[] args) {
    FunctInterface obj = (int x) -> x + 3;
    int result = obj.incrementBy3(10);
    System.out.println("Incremented Value: " + result);
  }

}

@FunctionalInterface
interface FunctInterface {
  public int incrementBy3(int num);
}
