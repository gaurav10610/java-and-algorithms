package searchingNsorting;

/**
 * Problem - Given two sorted arrays and a number x, find the pair(an element from each array) from arrays whose sum is closest to x
 */
public class FindClosestPairWithSumX {

    public static void main(String[] args) {
        int arr1[] = {1, 4, 5, 7};
        int arr2[] = {10, 20, 30, 40};

        int x = 38;

        int i = 0;
        int j = arr2.length - 1;

        int diff = Integer.MAX_VALUE;
        int resI = 0;
        int resJ = arr2.length - 1;

        while (i < arr1.length && j >= 0) {

            int tempDiff = Math.abs(arr1[i] + arr2[j] - x);

            if (tempDiff < diff) {
                diff = tempDiff;
                resI = i;
                resJ = j;
            }

            if (arr1[i] + arr2[j] > x) {
                j--;
            }

            /*
              arr1[i] + arr2[j] < x
              */
            i++;
        }

        System.out.printf("elements are: (%d, %d)", arr1[resI], arr2[resJ]);
    }

}
