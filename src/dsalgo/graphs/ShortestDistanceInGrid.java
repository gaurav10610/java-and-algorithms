package dsalgo.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * find the shortest distance from source to destination containing the given
 * value X
 * 
 * places marked with 0 in the grid are blocked path
 * 
 */
public class ShortestDistanceInGrid {

	public static void main(String[] args) {
		List<List<Integer>> grid = new ArrayList<List<Integer>>();

		int X = 9;

		grid.add(Arrays.asList(0, 1, 0, 1));
		grid.add(Arrays.asList(1, 0, 1, 1));
		grid.add(Arrays.asList(0, 1, 1, 1));
		grid.add(Arrays.asList(9, 1, 1, 1));

		int numRows = grid.size();
		int numColumns = grid.get(0).size();

		boolean[][] visited = new boolean[numRows][numColumns];

		/**
		 * mark all blocked places as visited
		 * 
		 */
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				if (grid.get(i).get(j) == 0) {
					visited[i][j] = true;
				}
			}
		}

		// GridPosition source = new GridPosition(0, 0);
		GridPosition source = new GridPosition(2, 3);

		int cost = findMinimumDistance(numRows, numColumns, grid, source, X, visited);

		if (cost < 0) {
			System.out.print("Grid position with value " + X + " is either not reachable from source or not found");
		} else {
			System.out.print("Minimum cost from source(" + source.x + "," + source.y + ") to grid position with value "
					+ X + " is " + cost);
		}
	}

	/**
	 * find minimum distance/cost from given source to destination with value X
	 * 
	 */
	public static int findMinimumDistance(int numRows, int numColumns, List<List<Integer>> grid, GridPosition source,
			int X, boolean[][] visited) {

		/**
		 * 
		 * this will keep the minimum cost of reaching to any node
		 */
		int[][] distanceMatrix = new int[numRows][numColumns];

		Queue<GridPosition> queue = new LinkedList<GridPosition>();
		queue.add(source);
		visited[source.x][source.y] = true;
		distanceMatrix[source.x][source.y] = 0;

		while (!queue.isEmpty()) {

			/**
			 * remove the head from the queue
			 * 
			 */
			GridPosition currentPosition = queue.poll();

			/**
			 * check if this is the destination, if it is destination then return the
			 * effective cost to reach here else keep searching
			 * 
			 */
			if (grid.get(currentPosition.x).get(currentPosition.y) == X) {
				return distanceMatrix[currentPosition.x][currentPosition.y];
			}

			/**
			 * get all the adjacents non-blocked grid positions
			 * 
			 */
			List<GridPosition> adjacents = getAdjacents(numRows, numColumns, currentPosition);

			for (GridPosition adjacent : adjacents) {

				/**
				 * check if this is a visited node
				 * 
				 */
				if (!visited[adjacent.x][adjacent.y]) {

					/**
					 * make adjacent node as visited
					 * 
					 */
					visited[adjacent.x][adjacent.y] = true;

					/**
					 * 
					 * store the shortest distance in the distance matrix
					 */
					distanceMatrix[adjacent.x][adjacent.y] = distanceMatrix[currentPosition.x][currentPosition.y] + 1;
					queue.add(adjacent);
				}
			}
		}
		return -1;
	}

	/**
	 * return all possible combinations
	 * 
	 */
	public static List<GridPosition> getAdjacents(int numRows, int numColumns, GridPosition position) {
		List<GridPosition> list = new ArrayList<GridPosition>();
		if ((position.x - 1) >= 0 && (position.y) < numColumns) {
			list.add(new GridPosition(position.x - 1, position.y));
		}
		if ((position.x) < numRows && (position.y + 1) < numColumns) {
			list.add(new GridPosition(position.x, position.y + 1));
		}
		if ((position.x + 1) < numRows && (position.y) < numColumns) {
			list.add(new GridPosition(position.x + 1, position.y));
		}
		if ((position.x) < numRows && (position.y - 1) >= 0) {
			list.add(new GridPosition(position.x, position.y - 1));
		}
		return list;
	}

}

/**
 * grid position
 * 
 */
class GridPosition {
	int x;
	int y;

	GridPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return this.x + "," + this.y;
	}
}
