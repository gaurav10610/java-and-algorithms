package dsalgo.tree;

import dsalgo.data.MockDataHelper;
import dsalgo.library.TreeNode;

public class BinaryTreeSearch {

	public static void main(String[] args) {

		TreeNode root = MockDataHelper.getBinaryTree();

		boolean valueFound = searchValue(root, 10);

		if (valueFound) {

			System.out.print("Value found in tree");
		} else {

			System.out.print("Value not found in tree");
		}
	}

	public static boolean searchValue(TreeNode root, int valueToSearch) {

		if (root == null) {
			return false;
		}

		if (root.getValue() == valueToSearch) {
			return true;
		}

		boolean valueFoundOnLeft = searchValue(root.getLeftChild(), valueToSearch);

		if (valueFoundOnLeft) {
			return true;
		}

		boolean valueFoundOnRight = searchValue(root.getRightChild(), valueToSearch);

		if (valueFoundOnRight) {
			return true;
		}

		return false;
	}

}
