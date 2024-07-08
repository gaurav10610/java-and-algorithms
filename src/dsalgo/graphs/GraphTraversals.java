package dsalgo.graphs;

import java.util.Arrays;
import dsalgo.library.GraphUtils;
import dsalgo.library.MyUnweightedGraph;

public class GraphTraversals {

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

		GraphUtils.breadthFirstTraversal(graph, 0);

		GraphUtils.iterativeDepthFirstTraversal(graph, 0);

		System.out.print("Recursive Depth First Traversal: ");

		boolean[] visitedArray = new boolean[graph.getTotalNodes()];
		Arrays.fill(visitedArray, false);
		GraphUtils.recursiveDepthFirstTraversal(graph, 0, visitedArray);
	}

}
