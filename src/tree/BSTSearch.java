package tree;

import data.MockDataHelper;
import library.TreeNode;

/**
 * Search a value in a given binary search tree
 * 
 * Time complexity - O(logN), N - No. of nodes in BST
 * 
 */
public class BSTSearch {

	public static void main(String[] args) {

		TreeNode root = MockDataHelper.getBST();

		boolean isValueFound = binarySearch(root, 7);
		if (isValueFound) {
			System.out.println("value found in tree");
		} else {
			System.out.println("value not found in tree");
		}
	}

	/**
	 * perform binary search
	 * 
	 * @param node
	 * @param value
	 * @return
	 */
	public static boolean binarySearch(TreeNode node, int value) {

		if (node == null) {

			return false;
		} else if (node.getValue() == value) {

			return true;
		} else if (node.getValue() < value) {

			return binarySearch(node.getRightChild(), value);
		} else {

			return binarySearch(node.getLeftChild(), value);
		}
	}

}
