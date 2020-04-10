package library;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class GraphUtils {

  /**
   * Recursive Depth First Traversal of a graph
   * 
   * @param graph
   * @param root
   */
  public static void recursiveDFS(MyUnweightedGraph graph, String root) {

    boolean[] visitedDFS = new boolean[graph.getTotalVertices()];
    visitedDFS[graph.getVertexIndex(root)] = true;
    System.out.print(root + " ");

    graph.getAdjacents(root).forEach((element) -> {
      if (!visitedDFS[element.intValue()]) {
        recursiveDFS(graph, graph.getNodeFromIndex(element.intValue()));
      }
    });
  }

  /**
   * Iterative Depth First Traversal of a graph
   * 
   * @param graph
   * @param root
   */
  public static void iterativeDFS(MyUnweightedGraph graph, String root) {

    boolean[] visitedDFS = new boolean[graph.getTotalVertices()];
    Stack<String> stack = new Stack<String>();
    Arrays.fill(visitedDFS, 0, visitedDFS.length, false);
    stack.push(root);

    while (!stack.isEmpty()) {
      String obj = stack.pop();

      // Stack may contain same vertex twice. So
      // we need to print the popped item only
      // if it is not visited.
      if (!visitedDFS[graph.getVertexIndex(obj)]) {
        System.out.print(obj + " ");
        visitedDFS[graph.getVertexIndex(obj)] = true;
      }

      graph.getAdjacents(obj).forEach((element) -> {
        if (!visitedDFS[element.intValue()]) {
          stack.push(graph.getNodeFromIndex(element.intValue()));
        }
      });
    }
  }

  /**
   * Breadth First Traversal of a graph
   * 
   * @param graph
   * @param root
   */
  public static void BFS(MyUnweightedGraph graph, String root) {

    boolean[] visitedBFS = new boolean[graph.getTotalVertices()];
    MyQueue queue = new MyQueue(graph.getTotalVertices());
    visitedBFS[graph.getVertexIndex(root)] = true;
    queue.enqueue(root);

    while (!queue.isEmpty()) {
      String node = (String) queue.dequeue();
      System.out.print(node + " ");
      graph.getAdjacents(node).forEach((element) -> {
        if (!visitedBFS[element.intValue()]) {
          visitedBFS[element.intValue()] = true;
          queue.enqueue(graph.getNodeFromIndex(element.intValue()));
        }
      });
    }
  }

  /**
   * This will return an adjacency list build from a tree's array representation
   * 
   * @param treeArrayRepresentation
   * @return
   */
  public static Map<Integer, Set<Integer>> buildAdjacencyListFromTreeArray(
      int[] treeArrayRepresentation) {
    Map<Integer, Set<Integer>> adjacencyList = new HashMap<Integer, Set<Integer>>();

    int i = 0;
    while (i < treeArrayRepresentation.length) {
      int node = treeArrayRepresentation[i];
      boolean isleftChildExist = false;
      boolean isrightChildExist = false;

      if (2 * i + 1 < treeArrayRepresentation.length) {
        isleftChildExist = true;
      }
      if (2 * i + 2 < treeArrayRepresentation.length) {
        isrightChildExist = true;
      }

      if (!adjacencyList.containsKey(node)) {
        Set<Integer> adjacentNodes = new HashSet<Integer>();

        if (isleftChildExist) {
          adjacentNodes.add(treeArrayRepresentation[2 * i + 1]);
          Set<Integer> adjacentNode1 = new HashSet<Integer>();
          adjacentNode1.add(node);
          adjacencyList.put(treeArrayRepresentation[2 * i + 1], adjacentNode1);
        }

        if (isrightChildExist) {
          adjacentNodes.add(treeArrayRepresentation[2 * i + 2]);
          Set<Integer> adjacentNode2 = new HashSet<Integer>();
          adjacentNode2.add(node);
          adjacencyList.put(treeArrayRepresentation[2 * i + 2], adjacentNode2);
        }

        adjacencyList.put(node, adjacentNodes);
      } else {

        if (isleftChildExist) {
          adjacencyList.get(node).add(treeArrayRepresentation[2 * i + 1]);
          Set<Integer> adjacentNode1 = new HashSet<Integer>();
          adjacentNode1.add(node);
          adjacencyList.put(treeArrayRepresentation[2 * i + 1], adjacentNode1);
        }

        if (isrightChildExist) {
          adjacencyList.get(node).add(treeArrayRepresentation[2 * i + 2]);
          Set<Integer> adjacentNode2 = new HashSet<Integer>();
          adjacentNode2.add(node);
          adjacencyList.put(treeArrayRepresentation[2 * i + 2], adjacentNode2);
        }
      }
      i++;
    }
    return adjacencyList;
  }

  /**
   * Print the adjacencyList
   * @param adjacencyList
   */
  public static void printAdjacencyList(Map<Integer, Set<Integer>> adjacencyList) {
    adjacencyList.forEach((key, value) -> {
      System.out.print(key + " -> ");
      value.forEach((node) -> {
        System.out.print(node + " ");
      });
      System.out.println();
    });
  }

}
