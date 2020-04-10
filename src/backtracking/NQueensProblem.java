package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {
 
  static List<int[]> positions = new ArrayList<int[]>();

  public static void main(String[] args) {
    int boardSize = 1;
    boolean areAllQueensPlaced = placeQueens(0, boardSize);
    if (areAllQueensPlaced) {
      positions.forEach((position) -> {
        System.out.println("(" + position[0] + "," + position[1] + ")");
      });
    } else {
      System.out.print("Not able to place all queens");
    }
  }

  public static boolean placeQueens(int queenNumber, int boardSize) {
    boolean isPlaced = false;
    boolean result;
    for (int column = 0; column < boardSize; column++) {
      result = isAttacked(queenNumber, column);

      if (!result) {
        int[] position = new int[2];
        position[0] = queenNumber;
        position[1] = column;
        positions.add(position);
        if (positions.size() == boardSize) {
          isPlaced = true;
          break;
        } else {
          result = placeQueens(queenNumber + 1, boardSize);
          if (result) {
            isPlaced = true;
            break;
          } else {
            positions.remove(queenNumber);
          }
        }
      }
    }
    return isPlaced;
  }

  public static boolean isAttacked(int x, int y) {
    boolean isAttacked = false;
    for (int[] position : positions) {

      // row attack check
      if (position[0] == x) {
        isAttacked = true;
        break;
      }
      // column attack check
      if (position[1] == y) {
        isAttacked = true;
        break;
      }

      // diagnol1 attack check
      if ((position[0] - position[1]) == (x - y)) {
        isAttacked = true;
        break;
      }

      // diagnol2 attack check
      if ((position[0] + position[1]) == (x + y)) {
        isAttacked = true;
        break;
      }
    }
    return isAttacked;
  }
}
