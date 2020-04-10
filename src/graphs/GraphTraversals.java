package graphs;

import java.util.Arrays;
import library.GraphUtils;
import library.MyUnweightedGraph;

public class GraphTraversals {

  public static void main(String[] args) {
    MyUnweightedGraph graph = new MyUnweightedGraph(5, false);

    // Add vertices
    graph.addVetrtex("A");
    graph.addVetrtex("B");
    graph.addVetrtex("C");
    graph.addVetrtex("D");
    graph.addVetrtex("E");

    // Add edges
    graph.addEdges("A", Arrays.asList("B", "E"));
    graph.addEdges("B", Arrays.asList("A", "C", "D"));
    graph.addEdges("C", Arrays.asList("B", "D", "E"));
    graph.addEdges("D", Arrays.asList("B", "C"));
    graph.addEdges("E", Arrays.asList("A", "C"));

    System.out.println("BFS Traversal: ");
    GraphUtils.BFS(graph, "D");
    System.out.println("\nIterative DFS Traversal: ");
    GraphUtils.iterativeDFS(graph, "E");
  }

}
