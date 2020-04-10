package array;

public class IfAllAreEquals {

  public static void main(String[] args) {
    int array[] = {50, 75, 15};
    for (int i = 0; i < array.length; i++) {

      while (array[i] % 2 == 0) {
        array[i] /= 2;
      }

      while (array[i] % 3 == 0) {
        array[i] /= 3;
      }
    }
    
    for (int j = 1; j < array.length; j++) {
      if (array[j] != array[j - 1]) {
        System.out.println("No all values can't be made equal.");
        return;
      }
    }
    System.out.println("Yes all values can't be made equal.");
  }

}
