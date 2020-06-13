package library;

import java.util.Arrays;
import java.util.Stack;

public class GraphUtils {

  /**
   * Recursive Depth First Traversal of a graph
   * 
   * @param graph
   * @param root
   */
  public static void recursiveDepthFirstTraversal(MyUnweightedGraph graph, Integer rootNodeIndex,
      boolean[] visitedArray) {

    System.out.print(rootNodeIndex + "->");
    visitedArray[rootNodeIndex] = true;

    for (Integer adjacent : graph.getAdjacents(rootNodeIndex)) {
      
      if (!visitedArray[adjacent]) {
        recursiveDepthFirstTraversal(graph, adjacent, visitedArray);
      }
    }
  }

  /**
   * Iterative Depth First Traversal of a graph
   * 
   * @param graph
   * @param root
   */
  public static void iterativeDepthFirstTraversal(MyUnweightedGraph graph, Integer rootNodeIndex) {

    System.out.print("Iterative Depth First Traversal: ");

    boolean[] visitedArray = new boolean[graph.getTotalNodes()];
    Arrays.fill(visitedArray, false);

    Stack<Integer> stack = new Stack<Integer>();
    stack.add(rootNodeIndex);

    while (!stack.isEmpty()) {

      Integer visitedNode = stack.pop();

      if (!visitedArray[visitedNode]) {
        System.out.print(visitedNode + "->");
        visitedArray[visitedNode] = true;
      }

      for (Integer adjacent : graph.getAdjacents(visitedNode)) {
        if (!visitedArray[adjacent]) {
          stack.add(adjacent);
        }
      }
    }
    System.out.println("");
  }

  /**
   * Breadth First Traversal of a graph
   * 
   * @param graph
   * @param root
   */
  public static void BreadthFirstTraversal(MyUnweightedGraph graph, Integer rootNodeIndex) {

    System.out.print("Breadth First Traversal: ");

    boolean[] visitedArray = new boolean[graph.getTotalNodes()];
    Arrays.fill(visitedArray, false);

    MyQueue queue = new MyQueue(graph.getTotalNodes());
    queue.enqueue(rootNodeIndex);
    visitedArray[rootNodeIndex] = true;

    while (!queue.isEmpty()) {

      Integer visitedNode = (Integer) queue.dequeue();
      System.out.print(visitedNode + "->");

      for (Integer adjacentNode : graph.getAdjacents(visitedNode)) {

        if (!visitedArray[adjacentNode]) {
          queue.enqueue(adjacentNode);
          visitedArray[adjacentNode] = true;
        }
      }
    }
    System.out.println("");
  }
}
