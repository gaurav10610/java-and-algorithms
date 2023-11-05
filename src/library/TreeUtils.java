package library;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeUtils {

	/**
	 * recursive in-order traversal of binary tree
	 */
	public static void printInOrderTraversalRecursive(TreeNode root) {
		if (root != null) {
			printInOrderTraversalRecursive(root.getLeftChild());
			System.out.print(root.getValue() + " ");
			printInOrderTraversalRecursive(root.getRightChild());
		}
	}

	/**
	 * recursive pre-order traversal of binary tree
	 */
	public static void printPreOrderTraversalRecursive(TreeNode root) {
		if (root != null) {
			System.out.print(root.getValue() + " ");
			printPreOrderTraversalRecursive(root.getLeftChild());
			printPreOrderTraversalRecursive(root.getRightChild());
		}
	}

	/**
	 * recursive post-order traversal of binary tree
	 */
	public static void printPostOrderTraversalRecursive(TreeNode root) {
		if (root != null) {
			printPostOrderTraversalRecursive(root.getLeftChild());
			printPostOrderTraversalRecursive(root.getRightChild());
			System.out.print(root.getValue() + " ");
		}
	}

	/**
	 * iterative pre-order traversal of binary tree
	 */
	public static void printPreOrderTraversalIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {

			TreeNode node = stack.pop();
			System.out.print(node.getValue() + " ");

			if (node.getRightChild() != null) {
				stack.push(node.getRightChild());
			}
			if (node.getLeftChild() != null) {
				stack.push(node.getLeftChild());
			}
		}
	}

	/**
	 * iterative post-order traversal of binary tree
	 */
	public static void printPostOrderTraversalIterative(TreeNode root) throws CloneNotSupportedException {

		// clone the original root as algorithm will be updating references the tree
		TreeNode newRoot = (TreeNode) root.clone();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(newRoot);

		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();

			/**
			 * 
			 * check if left child is null then check if right child is null or not
			 * 
			 * if right child is not null then push the right child in the stack and make
			 * the right child of the node as null to make sure that we never visit it again
			 * when we'll get back to parent again
			 * 
			 * if right child is null then simply pop the node
			 */
			if (node.leftChild == null) {

				if (node.rightChild != null) {

					stack.push(node.getRightChild());
					node.setRightChild(null);
				} else {

					System.out.print(node.getValue() + " ");
					stack.pop();
				}
			} else {

				/**
				 * 
				 * if left child is not null then push the left child in the stack and make the
				 * left child of the node as null to make sure that we never visit it again when
				 * we'll get back to parent again
				 */
				stack.push(node.getLeftChild());
				node.setLeftChild(null);
			}
		}
	}

	/**
	 * iterative in-order traversal of binary tree
	 */
	public static void printInOrderTraversalIterative(TreeNode root) throws CloneNotSupportedException {

		// clone the original root as algorithm will be updating references the tree
		TreeNode newRoot = (TreeNode) root.clone();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(newRoot);

		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();

			/**
			 * 
			 * check if left child is null then pop the node and push the right child in the
			 * stack if it is not null
			 */
			if (node.leftChild == null) {
				System.out.print(node.getValue() + " ");
				stack.pop();

				if (node.rightChild != null) {
					stack.push(node.getRightChild());
				}
			} else {

				/**
				 * 
				 * if left child is not null then push the left child in the stack and make the
				 * left child of the node as null to make sure that we never visit it again when
				 * we'll get back to parent again
				 */
				stack.push(node.getLeftChild());
				node.setLeftChild(null);
			}
		}
	}

	/**
	 * iterative level-order traversal of binary tree
	 */
	public static void printLevelOrderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.getValue() + " ");

			if (node.getLeftChild() != null) {
				queue.add(node.getLeftChild());
			}

			if (node.getRightChild() != null) {
				queue.add(node.getRightChild());
			}
		}
	}

	/**
	 * this will find the path from root to the node having given value
	 * 
	 * @param root
	 * @param nodeValue
	 * @param path
	 * @return
	 */
	public static boolean findNodePathFromRoot(TreeNode root, int nodeValue, Stack<TreeNode> path) {

		if (root == null) {

			return false;
		} else {

			// add current node in path
			path.add(root);

			if (root.getValue() == nodeValue) {
				return true;
			}

			boolean foundOnLeft = findNodePathFromRoot(root.getLeftChild(), nodeValue, path);

			if (foundOnLeft) {
				return true;
			}

			boolean foundOnRight = findNodePathFromRoot(root.getRightChild(), nodeValue, path);

			if (foundOnRight) {
				return true;
			}

			// not found among the descendents of this node
			path.pop();

			return false;
		}
	}

	public static TreeNode findLowestCommonAncestor(TreeNode root, int nodeValue1, int nodeValue2,
			Stack<TreeNode> rootToNode1Path, Stack<TreeNode> rootToNode2Path) {

		TreeNode lca = null;

		int i = 0;
		while (i < rootToNode1Path.size() && i < rootToNode2Path.size()) {

			if (rootToNode1Path.get(i).getValue() == rootToNode2Path.get(i).getValue()) {

				lca = rootToNode1Path.get(i);
			} else {

				break;
			}
			i++;
		}

		return lca;
	}
}
