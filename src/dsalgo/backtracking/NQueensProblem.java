package dsalgo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The N Queen is the problem of placing N chess queens on an N�N chessboard so
 * that no two queens attack each other.
 *
 * Solution Hint - Use backtracking
 * 
 */
public class NQueensProblem {

	public static void main(String[] args) {
		int boardSize = 8;

		List<Position> queensPositions = new ArrayList<>();

		/**
		 * try placing all queens recursively
		 * 
		 */
		boolean isAllQueensPlaced = placeQueen(queensPositions, 0, boardSize);

		if (isAllQueensPlaced) {

			for (Position position : queensPositions) {

				System.out.printf("%s ", position);
			}
		} else {

			System.out.printf("unable to place all queens on a board of size %d", boardSize);
		}
	}

	/**
	 * place a queen
	 * 
	 * @param queensPositions
	 * @param queenNumber
	 * @param boardSize
	 * @return
	 */
	public static boolean placeQueen(List<Position> queensPositions, int queenNumber, int boardSize) {
		boolean isQueenPlaced = false;

		for (int c = 0; c < boardSize; c++) {

			/**
			 * create a position of current queen using row number and current column
			 * 
			 */
			Position currentQueenPosition = new Position(queenNumber, c);

			/**
			 * 
			 * evaluate if placing the current queen at this position will not led to an
			 * attack by other already placed queens
			 * 
			 */
			boolean isAttacked = isQueenAttacked(queensPositions, currentQueenPosition);

			/**
			 * 
			 * process if queen is placed at a safe position
			 * 
			 */
			if (!isAttacked) {

				/**
				 * 
				 * fix current queen's position
				 */
				queensPositions.add(currentQueenPosition);

				if (queenNumber == boardSize - 1) {

					/**
					 * 
					 * if this was the last queen to placed then mark the current queen as placed
					 * and return
					 */
					isQueenPlaced = true;
					break;
				}

				/**
				 * 
				 * if current queen is not the last queen to be placed then try placing the next
				 * queen now
				 * 
				 */
				boolean isNextQueenPlaced = placeQueen(queensPositions, queenNumber + 1, boardSize);

				if (isNextQueenPlaced) {

					/**
					 * 
					 * if all subsequent queens are placed then mark current queen as placed and
					 * return
					 */
					isQueenPlaced = true;
					break;
				}

				/**
				 * 
				 * if current queen's current position is leading to attack on other subsequent
				 * queen then revert back the position that we fixed before and try placing
				 * current queen on next adjacent position
				 * 
				 */
				queensPositions.remove(queensPositions.size() - 1);
			}
		}

		return isQueenPlaced;
	}

	/**
	 * check if placing the current queen at this position will not led to an attack
	 * by other already placed queens
	 * 
	 * @param queensPositions
	 * @param currentQueenPosition
	 * @return
	 */
	public static boolean isQueenAttacked(List<Position> queensPositions, Position currentQueenPosition) {

		boolean isAttacked = false;

		for (Position prevQueenPosition : queensPositions) {

			/**
			 * 
			 * check the following conditions -
			 * 
			 * 1. current queen is not being placed in same row as any of already placed
			 * queens
			 * 
			 * 2. current queen is not being placed in same column as any of already placed
			 * queens
			 * 
			 * 3. current queen is not being placed in same diagonal as any of already
			 * placed queens
			 * 
			 */
			if (prevQueenPosition.column == currentQueenPosition.column
					|| Math.abs(prevQueenPosition.column - currentQueenPosition.column) == Math
							.abs(prevQueenPosition.row - currentQueenPosition.row)) {

				isAttacked = true;
				break;
			}
		}
		return isAttacked;
	}
}

/**
 * Custom data structure to represent a position on the chess board
 *
 */
class Position {
	int row;
	int column;

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public String toString() {
		return "[" + row + ", " + column + "]";
	}
}
