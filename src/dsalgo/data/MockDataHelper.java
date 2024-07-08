package dsalgo.data;

import dsalgo.library.TreeNode;

/**
 * 
 * This is just a helper class for mock data
 *
 */
public class MockDataHelper {

	public static TreeNode getBinaryTree() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);

		node1.setLeftChild(node2);
		node1.setRightChild(node3);
		node2.setLeftChild(node4);
		node2.setRightChild(node5);
		node3.setLeftChild(node6);
		node3.setRightChild(node7);
		node5.setLeftChild(node8);
		node5.setRightChild(node9);
		node7.setLeftChild(node10);
		return node1;
	}

	public static TreeNode getBST() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);

		node6.setLeftChild(node4);
		node6.setRightChild(node8);
		node4.setLeftChild(node3);
		node4.setRightChild(node5);
		node3.setLeftChild(node1);
		node8.setLeftChild(node7);
		node8.setRightChild(node9);
		node9.setRightChild(node10);
		return node6;
	}
}
