package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unweighted graph with adjacency list
 * 
 * @author Gaurav
 *
 */
public class MyUnweightedGraph {

  private List<Integer>[] graphAdjacencyList;
  private int totalNodes;
  private boolean isDirected;
  private List<Integer> allNodes;

  @SuppressWarnings("unchecked")
  public MyUnweightedGraph(int totalNodes, boolean isDirected) {
    this.graphAdjacencyList = new ArrayList[totalNodes];
    this.isDirected = isDirected;
    this.totalNodes = totalNodes;

    // initialize with empty array list
    for (int i = 0; i < totalNodes; i++) {
      graphAdjacencyList[i] = new ArrayList<Integer>();
    }

  }

  public List<Integer> getAllNodes() {

    if (allNodes == null) {
      allNodes = new ArrayList<Integer>();
      int nodeIndex = 0;

      while (nodeIndex < totalNodes) {
        allNodes.add(nodeIndex);
        nodeIndex++;
      }
    }
    return allNodes;
  }

  public int getTotalNodes() {
    return totalNodes;
  }

  public boolean isConnected(Integer node1Index, Integer node2Index) {
    return graphAdjacencyList[node1Index].contains(node2Index) ? true : false;
  }

  // Add an edge
  public void addEdge(Integer node1Index, Integer node2Index) {
    if (!graphAdjacencyList[node1Index].contains(node2Index)) {
      graphAdjacencyList[node1Index].add(node2Index);
    }

    if (!isDirected && !graphAdjacencyList[node2Index].contains(node1Index)) {
      graphAdjacencyList[node2Index].add(node1Index);
    }
  }

  public void addEdges(Integer node1Index, List<Integer> nodes) {
    for (Integer node2Index : nodes) {
      addEdge(node1Index, node2Index);
    }
  }

  public List<Integer> getAdjacents(Integer nodeIndex) {
    return graphAdjacencyList[nodeIndex];
  }

  public List<GraphEdge> getAllEdges() {
    List<GraphEdge> edgeList = new ArrayList<GraphEdge>();

    int nodeIndex = 0;
    for (List<Integer> adjacentsNodes : graphAdjacencyList) {

      if (!adjacentsNodes.isEmpty()) {

        for (Integer adjacentNodeIndex : adjacentsNodes) {
          GraphEdge edge = new GraphEdge(nodeIndex, adjacentNodeIndex, isDirected);

          if (isDirected) {

            edgeList.add(edge);
          } else {

            // add edge in the list if it is not considered yet
            if (!edgeList.contains(edge)) {
              edgeList.add(edge);
            }
          }
        }
      }
      nodeIndex++;
    }
    return edgeList;
  }

  @Override
  public String toString() {
    return Arrays.toString(graphAdjacencyList);
  }
}
