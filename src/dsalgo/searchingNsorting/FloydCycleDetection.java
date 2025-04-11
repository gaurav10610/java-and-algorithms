package dsalgo.searchingNsorting;

/**
 * Find repeating number in an array of size N+1 containing numbers from 1 to N
 * but just one number repeating. Find the repeating number.
 *
 * Time Complexity - O(N)
 * 
 * Algorithm - Floyd's Tortoise and Hare (Cycle Detection)
 */
public class FloydCycleDetection {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 4, 5, 6 }; // 3 is repeating

        // Step 1: Find intersection point inside the cycle
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Step 2: Find the entry point of the cycle (i.e., the duplicate number)
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        System.out.println("Repeating number is: " + fast);
    }
}
