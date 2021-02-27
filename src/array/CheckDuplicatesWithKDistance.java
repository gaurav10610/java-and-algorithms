package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given a list of numbers and a constant K, find out all the numbers which have duplicate values in
 * the list. A duplicate is identified as a same value if it exist within K distance. Refer below
 * examples -
 * 
 * Input - [1,2,1,3,4,5,6], (K = 3) Output - 1 -> Explaination: only 1 have duplicate values within
 * K distance
 * 
 * Input - [1,2,3,4,5,1, 6], (K = 3) Output - Print Nothing -> Explaination: No number have
 * duplicate values within K distance
 *
 */
public class CheckDuplicatesWithKDistance {

  public static void main(String[] args) {

    int[] numbers = {1, 2, 1, 3, 1, 3, 6};

    int K = 3;

    /**
     * 
     * set of K values at max to keep track of values within K distance at a particular index
     */
    Set<Integer> set = new HashSet<>();

    Set<Integer> result = new HashSet<Integer>();

    for (int i = 0; i < numbers.length; i++) {

      /**
       * 
       * check for duplicates
       */
      if (set.contains(numbers[i])) {
        result.add(numbers[i]);
      } else {

        if (set.size() < K) {

          /**
           * 
           * simply add the value in set if size is less than
           */
          set.add(numbers[i]);
        } else {

          /**
           * 
           * if size of the set is already K evict a number from set in FIFO order
           */
          int numberToEvict = numbers[i - K];
          set.remove(numberToEvict);
          set.add(numbers[i]);
        }
      }
    }

    System.out.print(Arrays.toString(result.toArray()));
  }

}
