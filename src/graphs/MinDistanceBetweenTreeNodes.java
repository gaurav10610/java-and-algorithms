package graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import library.GraphUtils;
import library.MyQueue;

public class MinDistanceBetweenTreeNodes {

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    System.out.println("Minimum distance is " + getMinDistance(array, 10, 15));
  }

  public static int getMinDistance(int[] array, int node1, int node2) {
    Map<Integer, Set<Integer>> adjacencyList = GraphUtils.buildAdjacencyListFromTreeArray(array);
    //GraphUtils.printAdjacencyList(adjacencyList);
    Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
    Arrays.stream(array).forEach((node) -> {
      visited.put(node, false);
    });

    Map<Integer, Integer> minPathLength = new HashMap<Integer, Integer>();

    MyQueue queue = new MyQueue(array.length);
    visited.put(node1, true);
    minPathLength.put(node1, 0);
    queue.enqueue(Integer.valueOf(node1));

    while (!queue.isEmpty()) {

      Integer node = (Integer) queue.dequeue();
      if (node == node2) {
        return minPathLength.get(node);
      }
      
      adjacencyList.get(node).forEach((neighbour) -> {
        if (!visited.get(neighbour).booleanValue()) {
          queue.enqueue(neighbour);
          visited.put(neighbour, true);
          minPathLength.put(neighbour, minPathLength.get(node) + 1);
        }
      });
    }

    return -1;
  }

}
