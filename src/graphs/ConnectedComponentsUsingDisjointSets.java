package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import library.GraphEdge;
import library.MyUnweightedGraph;

/**
 * Given a graph, find the total number of connected components in it using
 * disjoint sets algorithm
 *
 */
public class ConnectedComponentsUsingDisjointSets {

	public static void main(String[] args) {

		int totalNodes = 8;
		int[] parents = new int[totalNodes];

		/**
		 * initially all the nodes are made their own parent thereby initializing the
		 * whole parent array with -1
		 * 
		 */
		Arrays.fill(parents, -1);

		MyUnweightedGraph graph = new MyUnweightedGraph(totalNodes, false);

		// graph.addEdge(0, 1);
		// graph.addEdge(1, 2);
		// graph.addEdge(2, 3);
		// graph.addEdge(3, 0);
		// graph.addEdge(3, 4);
		// graph.addEdge(4, 5);
		// graph.addEdge(5, 6);
		// graph.addEdge(6, 7);
		// graph.addEdge(7, 4);

		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(5, 3);
		graph.addEdge(3, 4);
		graph.addEdge(6, 7);

		for (GraphEdge edge : graph.getAllEdges()) {

			int parent1 = fetchParent(parents, edge.getStartIndex());
			int parent2 = fetchParent(parents, edge.getEndIndex());

			if (parent1 != parent2) {

				/**
				 * check which ever node is parent to more nodes in graph, make it the parent of
				 * the other
				 * 
				 */
				if (Math.abs(parents[parent1]) >= Math.abs(parents[parent2])) {
					parents[parent1] = parents[parent1] + parents[parent2];
					parents[parent2] = parent1;
				} else {
					parents[parent2] = parents[parent1] + parents[parent2];
					parents[parent1] = parent2;
				}
			}
		}

		List<Integer> list = new ArrayList<>();

		System.out.println(Arrays.toString(parents));

		/**
		 * check total number of distinct parents after taking disjoint union set
		 * operation
		 * 
		 */
		Arrays.stream(parents).filter(parent -> (parent < 0)).forEach((parent) -> list.add(parent));

		System.out.println("total number of connected components: " + list.size());
	}

	/**
	 * 
	 * fetch parent of provided node, if the node itself is not it's own parent then
	 * recursively fetch it. Negative value in parent array at node's index denotes
	 * that node is it's own parent
	 * 
	 */
	private static int fetchParent(int[] parents, int nodeIndex) {
		if (parents[nodeIndex] < 0) {
			return nodeIndex;
		} else {
			return fetchParent(parents, parents[nodeIndex]);
		}
	}
}
