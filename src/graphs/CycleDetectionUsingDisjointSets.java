package graphs;

import java.util.Arrays;
import library.MyUnweightedGraph;

public class CycleDetectionUsingDisjointSets {

  public static void main(String[] args) {
    MyUnweightedGraph graph = new MyUnweightedGraph(8, true);

    graph.addVetrtex("A");
    graph.addVetrtex("B");
    graph.addVetrtex("C");
    graph.addVetrtex("D");
    graph.addVetrtex("E");
    graph.addVetrtex("F");
    graph.addVetrtex("G");
    graph.addVetrtex("H");

    graph.addEdge("A", "B");
    graph.addEdge("B", "C");
    graph.addEdge("C", "D");
    graph.addEdge("D", "A");
    graph.addEdge("D", "E");
    graph.addEdge("E", "F");
    graph.addEdge("F", "G");
    graph.addEdge("G", "H");
    graph.addEdge("H", "E");

    printNumberOfCycles(graph);
  }

  public static void printNumberOfCycles(MyUnweightedGraph graph) {
    int numberOfCycles = 0;
    int[] setArray = new int[graph.getTotalVertices()];
    Arrays.fill(setArray, -1);

    for (String[] edge : graph.getAllEdges()) {
      int parent1 = findParent(graph.getVertexIndex(edge[0]), setArray);
      int parent2 = findParent(graph.getVertexIndex(edge[1]), setArray);
      if (parent1 == parent2) {
        numberOfCycles++;
      } else {
        if (Math.abs(setArray[parent1]) >= Math.abs(setArray[parent2])) {
          setArray[parent1] = setArray[parent1] + setArray[parent2];
          setArray[parent2] = parent1;
        } else {
          setArray[parent2] = setArray[parent2] + setArray[parent1];
          setArray[parent1] = parent2;
        }
      }
    }
    System.out.println("Number of cycles in the graph are: " + numberOfCycles);
  }

  public static int findParent(int vertexIndex, int[] setArray) {
    if (setArray[vertexIndex] < 0) {
      return vertexIndex;
    } else {
      return findParent(setArray[vertexIndex], setArray);
    }
  }

}
