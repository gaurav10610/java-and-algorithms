package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import library.MyUnweightedGraph;

public class MinimumDistanceBetweenTwoNodesInGraph {

  public static void main(String[] args) {
    MyUnweightedGraph graph = new MyUnweightedGraph(8, false);

    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 0);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(5, 6);
    graph.addEdge(6, 7);
    graph.addEdge(7, 4);

    int totalNodes = 8;

    int node1 = 0;
    int node2 = 1;

    int[] parent = new int[8];
    int[] distance = new int[8];

    boolean result = findDistanceBetweenNodes(graph, node1, node2, totalNodes, parent, distance);

    if (result) {

      System.out
          .print("Minimum distance between " + node1 + " and " + " node2 is: " + distance[node2]);
    } else {

      System.out.print("No path exist from: " + node1 + " to " + node2);
    }
  }

  public static boolean findDistanceBetweenNodes(MyUnweightedGraph graph, int node1, int node2,
      int totalNodes, int[] parent, int[] distance) {

    Queue<Integer> queue = new LinkedList<Integer>();
    boolean[] visitedArray = new boolean[8];
    Arrays.fill(visitedArray, false);

    // add source/root in queue
    queue.add(node1);
    visitedArray[node1] = true;

    // set distance to source as 0
    distance[node1] = 0;

    while (!queue.isEmpty()) {

      int traversedNode = queue.poll();

      for (int node : graph.getAdjacents(traversedNode)) {

        // check if not visited
        if (!visitedArray[node]) {

          queue.add(node);

          // mark this adjacent visited
          visitedArray[node] = true;

          // set parent node
          parent[node] = traversedNode;

          // set distance
          distance[node] = distance[parent[node]] + 1;

          // node found
          if (node == node2) {
            return true;
          }

        }
      }
    }

    return false;
  }

}
