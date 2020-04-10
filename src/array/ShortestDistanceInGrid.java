package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import library.MyQueue;

public class ShortestDistanceInGrid {

  public static void main(String[] args) {
    ShortestDistanceInGrid obj = new ShortestDistanceInGrid();
    List<List<Integer>> grid = new ArrayList<List<Integer>>();
//    grid.add(Arrays.asList(1, 0, 0, 9));
//    grid.add(Arrays.asList(1, 1, 1, 0));
//    grid.add(Arrays.asList(1, 0, 0, 1));
//    grid.add(Arrays.asList(1, 1, 1, 1));
    
    grid.add(Arrays.asList(0, 1, 0, 1));
    grid.add(Arrays.asList(1, 0, 1, 1));
    grid.add(Arrays.asList(0, 1, 1, 1));
    grid.add(Arrays.asList(9, 1, 1, 1));
    int cost = obj.minDistance(4, 4, grid);
    System.out.print(cost);
  }

  public int minDistance(int numRows, int numColumns, List<List<Integer>> grid) {
    boolean[][] visited = new boolean[numRows][numColumns];
    int[][] costMatrix = new int[numRows][numColumns];

    // Marking all blocked nodes as visited
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numColumns; j++) {
        if (grid.get(i).get(j) == 0) {
          visited[i][j] = true;
        }
      }
    }

    MyQueue queue = new MyQueue(numRows * numColumns);
    Node source = new Node(0, 3);
    visited[source.x][source.y] = true;
    costMatrix[source.x][source.y] = 0;
    queue.enqueue(source);

    while (!queue.isEmpty()) {
      Node node = (Node) queue.dequeue();
//      System.out.print("(" + node.x + "," + node.y + ") -> ");
      if (grid.get(node.x).get(node.y) == 9) {
        return costMatrix[node.x][node.y];
      }
      List<Node> adjacentNodes = getAdjacents(numRows, numColumns, node);
      for (int k = 0; k < adjacentNodes.size(); k++) {
        Node element = adjacentNodes.get(k);
        if (!visited[element.x][element.y]) {
          visited[element.x][element.y] = true;
          costMatrix[element.x][element.y] = costMatrix[node.x][node.y] + 1;
          queue.enqueue(element);
        }
      }
    }
    return -1;
  }

  public List<Node> getAdjacents(int numRows, int numColumns, Node node) {
    List<Node> list = new ArrayList<Node>();
    if ((node.x - 1) >= 0 && (node.y) < numColumns) {
      list.add(new Node(node.x - 1, node.y));
    }
    if ((node.x) < numRows && (node.y + 1) < numColumns) {
      list.add(new Node(node.x, node.y + 1));
    }
    if ((node.x + 1) < numRows && (node.y) < numColumns) {
      list.add(new Node(node.x + 1, node.y));
    }
    if ((node.x) < numRows && (node.y - 1) >= 0) {
      list.add(new Node(node.x, node.y - 1));
    }
    return list;
  }

}


class Node {
  int x;
  int y;

  Node(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return this.x + "," + this.y;
  }
}
