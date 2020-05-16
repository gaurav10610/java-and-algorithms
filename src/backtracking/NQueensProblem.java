package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {

  static List<int[]> positions = new ArrayList<int[]>();

  public static void main(String[] args) {
    int boardSize = 4;
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
    for (int i = 0; i < boardSize; i++) {
      result = isAttacked(queenNumber, i);
      if (!result) {
        int[] position = new int[2];
        position[0] = queenNumber;
        position[1] = i;
        positions.add(position);
        if (queenNumber < boardSize - 1) {
          result = placeQueens(queenNumber + 1, boardSize);
          if (result) {
            isPlaced = true;
            break;
          } else {
            positions.remove(positions.size() - 1);
          }
        } else {
          isPlaced = true;
          break;
        }
      }
    }
    return isPlaced;
  }

  public static boolean isAttacked(int x, int y) {
    boolean isAttacked = false;
    for (int[] position : positions) {
      int X = position[0];
      int Y = position[1];
      if ((X == x) || (Y == y) || ((X + Y) == (x + y)) || ((X - Y) == (x - y))) {
        isAttacked = true;
        break;
      }
    }
    return isAttacked;
  }
}
