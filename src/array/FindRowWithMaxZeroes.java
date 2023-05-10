package array;

/**
 * 
 * Given a matrix of size M*N. Find the row with maximum number of zeroes given that in a row all
 * the zeroes will appear only after all the ones.Refer below example
 * 
 * Input -> [[1 1 1 0 0] [1 1 0 0 0] [0 0 0 0 0]]
 * 
 * Output -> 3
 * 
 * Explaination -> 3rd row has maximum number of zeroes among all the rows
 * 
 */
public class FindRowWithMaxZeroes {

  public static void main(String[] args) {

    int[][] matrix = {{1, 1, 1, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}};

    int maxZeroes = Integer.MIN_VALUE;
    int rowNumber = 0;

    int totalRows = matrix.length;
    int totalColumns = matrix[0].length;

    for (int i = 0; i < totalRows; i++) {
      int lastOnesIndex = findLastOnesIndex(matrix[i], 0, totalColumns - 1);

      int totalZeroes = (lastOnesIndex < 0) ? totalColumns : (totalColumns - lastOnesIndex - 1);

      if (totalZeroes >= maxZeroes) {
        maxZeroes = totalZeroes;
        rowNumber = i;
      }
    }

    System.out
        .println((rowNumber + 1) + " row has maximum number of zeroes with count: " + maxZeroes);
  }

  /**
   * 
   * find the index of the last one in an array
   * 
   * @param array
   * @param start
   * @param end
   * @return
   */
  public static int findLastOnesIndex(int[] array, int start, int end) {

    if (end >= start) {

      /**
       * 
       * get to the middle of start and end index
       */
      int mid = start + (end - start) / 2;

      if (array[mid] == 1 && ((start == end) || (array[mid + 1] == 0))) {
        return mid;
      }

      /**
       * 
       * case when there is 1 at mid and a 1 after it
       */
      if (array[mid] == 1) {
        return findLastOnesIndex(array, mid + 1, end);
      }

      /**
       * 
       * case when there is a zero at mid
       */
      return findLastOnesIndex(array, start, mid - 1);
    }
    return -1;
  }
}
