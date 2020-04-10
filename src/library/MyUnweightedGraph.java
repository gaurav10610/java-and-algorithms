package library;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Unweighted graph with adjacency list
 * 
 * @author Gaurav
 *
 */
public class MyUnweightedGraph {

  private List<Integer>[] graphAdjacencyList;
  private List<String> vertexIndices;
  private int totalVertices;
  private boolean isDirected;

  @SuppressWarnings("unchecked")
  public MyUnweightedGraph(int totalVertices,boolean isDirected) {
    this.totalVertices = totalVertices;
    graphAdjacencyList = new LinkedList[totalVertices];
    vertexIndices = new ArrayList<String>();
    this.isDirected = isDirected;

    for (int i = 0; i < graphAdjacencyList.length; i++) {
      graphAdjacencyList[i] = new LinkedList<Integer>();
    }
  }

  public int getVertexIndex(String node) {
    return vertexIndices.indexOf(node);
  }

  public int getTotalVertices() {
    return totalVertices;
  }

  public String getNodeFromIndex(int index) {
    return vertexIndices.get(index);
  }

  // Add a new vertex
  public void addVetrtex(String vertex) {
    vertexIndices.add(vertex);
  }

  public boolean isConnected(String node1, String node2) {
    return graphAdjacencyList[vertexIndices.indexOf(node1)].contains(vertexIndices.indexOf(node2))
        ? true
        : false;
  }

  // Add an edge
  public void addEdge(String node1, String node2) {
    int node1Index = vertexIndices.indexOf(node1);
    int node2Index = vertexIndices.indexOf(node2);

    if (!graphAdjacencyList[node1Index].contains(node2Index))
      graphAdjacencyList[node1Index].add(node2Index);

    if (!isDirected && !graphAdjacencyList[node2Index].contains(node1Index))
      graphAdjacencyList[node2Index].add(node1Index);
  }

  // Add edges in the graph
  public void addEdges(String node1, List<String> nodes) {
    int node1Index = vertexIndices.indexOf(node1);

    nodes.forEach((node) -> {
      int nodeIndex = vertexIndices.indexOf(node);
      if (!graphAdjacencyList[node1Index].contains(nodeIndex))
        graphAdjacencyList[node1Index].add(nodeIndex);

      if (!graphAdjacencyList[nodeIndex].contains(node1Index))
        graphAdjacencyList[nodeIndex].add(node1Index);
    });
  }

  // Remove an edge
  public void removeEdge(String node1, String node2) {
    int node1Index = vertexIndices.indexOf(node1);
    int node2Index = vertexIndices.indexOf(node2);

    graphAdjacencyList[node1Index].remove(node2Index);
    graphAdjacencyList[node2Index].remove(node1Index);
  }

  // Returns all adjacent
  public List<Integer> getAdjacents(String node) {
    int nodeIndex = vertexIndices.indexOf(node);
    return graphAdjacencyList[nodeIndex];
  }

  public List<String> getAllVertices() {
    return vertexIndices;
  }

  public List<String[]> getAllEdges() {
    List<String[]> edgeList = new ArrayList<String[]>();
    for (int i = 0; i < vertexIndices.size(); i++) {
      List<Integer> adjacentsList = graphAdjacencyList[i];
      for (Integer adjacentNode : adjacentsList) {
        String[] edge = new String[2];
        edge[0] = vertexIndices.get(i);
        edge[1] = vertexIndices.get(adjacentNode);
        edgeList.add(edge);
      }
    }
    return edgeList;
  }
}
