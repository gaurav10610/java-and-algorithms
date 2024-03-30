package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of numbers and a constant K, find out all the numbers which have
 * duplicate values in the list. A duplicate is identified as a same value if it
 * exist within K distance. Refer below examples -
 * <p>
 * Input - [1,2,1,3,4,5,6], (K = 3)
 * <p>
 * Output - 1
 * <p>
 * Explanation: only 1 have duplicate values within K distance
 * <p>
 * <p>
 * Input - [1,2,3,4,5,1, 6], (K = 3)
 * <p>
 * Output - Print Nothing
 * <p>
 * Explanation: No number have duplicate values within K distance
 */
public class CheckDuplicatesWithKDistance {

    public static void main(String[] args) {

        int[] numbers = { 1, 2, 100, 1, 2, 4, 5, 6, 5 };

        int K = 3;

        /*
          set of K values at max to keep track of values within K distance at a
          particular index
         */
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {

            /*
              check for duplicates
             */
            if (set.contains(numbers[i])) {
                System.out.println("duplicate: " + numbers[i]);
            }

            if (i - K > -1) {
                int numberToEvict = numbers[i - K];
                set.remove(numberToEvict);
            }
            set.add(numbers[i]);
        }
    }

}
