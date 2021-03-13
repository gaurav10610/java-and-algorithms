package array;

/**
 * 
 * Find the Number Occurring Odd Number of Times
 * 
 * Input : arr = {1, 2, 3, 2, 3, 1, 3}
 * 
 * Output : 3
 *
 */
public class FindNumberOccurOddTimes {

  public static void main(String[] args) {
    int[] array = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};

    /**
     * 
     * XOR of two elements is 0 if both elements are same and XOR of a number x with 0 is x
     * 
     */
    int xorResult = 0;
    for (int number : array) {
      xorResult = xorResult ^ number;
    }

    System.out.print("Number occured odd number of times is: " + xorResult);
  }

}
