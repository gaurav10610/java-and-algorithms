package dsalgo.tree;

import dsalgo.library.StackUsingQueue;
import dsalgo.library.TreeNode;

/**
 * 
 * Given the root node of a binary, print the post traversal for the binary tree
 * using queue data structure
 *
 */
public class BinaryTreePostOrderUsingQueue {

	public static void main(String[] args) throws CloneNotSupportedException {

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

		node1.setLeftChild(node2);
		node1.setRightChild(node3);
		node2.setLeftChild(node4);
		node2.setRightChild(node5);
		node3.setLeftChild(node6);
		node3.setRightChild(node7);

		// call dfs
		printPostOrderTraversal(node1);
	}

	/**
	 * 
	 * DFS logic
	 */
	public static void printPostOrderTraversal(TreeNode root) throws CloneNotSupportedException {

		TreeNode temp = (TreeNode) root.clone();

		StackUsingQueue<TreeNode> stack = new StackUsingQueue<>();

		stack.push(temp);

		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.getLeftChild() == null) {

				if (node.getRightChild() != null) {

					stack.push(node.getRightChild());
					node.setRightChild(null);
				} else {

					System.out.print(node.getValue() + " ");
					stack.pop();
				}
			} else {
				stack.push(node.getLeftChild());
				node.setLeftChild(null);
			}
		}
	}
}
