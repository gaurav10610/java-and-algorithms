package graphs;

import java.util.Arrays;
import java.util.List;
import library.GraphEdge;
import library.MyUnweightedGraph;

/**
 * 
 * find cycles in a graph using disjoint sets
 *
 */
public class CycleDetectionUsingDisjointSets {

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

		printNumberOfCycles(graph);
	}

	public static void printNumberOfCycles(MyUnweightedGraph graph) {
		int numberOfCycles = 0;
		int[] setArray = new int[graph.getTotalNodes()];
		Arrays.fill(setArray, -1);

		List<GraphEdge> edges = graph.getAllEdges();

		for (GraphEdge edge : edges) {

			int parent1 = findParent(edge.getStartIndex(), setArray);
			int parent2 = findParent(edge.getEndIndex(), setArray);

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
