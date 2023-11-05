package tree;

import java.util.LinkedList;
import java.util.Queue;

import data.MockDataHelper;
import library.TreeNode;

/**
 * 
 * evaluate height of a binary tree using both recursive and iterative
 * 
 */
public class BinaryTreeHeight {

	public static void main(String[] args) {
		TreeNode root = MockDataHelper.getBinaryTree();

		System.out.println("height of the binary tree: " + getTreeHeightRecursive(root));
		System.out.println("height of the binary tree: " + getTreeHeightIterative(root));
	}

	public static int getTreeHeightRecursive(TreeNode node) {
		if (node == null) {
			return 0;
		}

		return 1 + Math.max(getTreeHeightRecursive(node.getLeftChild()), getTreeHeightRecursive(node.getRightChild()));
	}

	public static int getTreeHeightIterative(TreeNode root) {
		int height = 0;

		if (root == null) {
			return height;
		}

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();

			if (node == null) {
				height++;
			}

			if (node != null) {
				if (node.getLeftChild() != null) {
					queue.add(node.getLeftChild());
				}

				if (node.getRightChild() != null) {
					queue.add(node.getRightChild());
				}
			} else if (!queue.isEmpty()) {

				/**
				 * 
				 * mark a new level by padding the queue with null values
				 * 
				 */
				queue.add(null);
			}

		}

		return height;
	}

}
