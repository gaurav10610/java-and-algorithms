package dsalgo.tree;

import dsalgo.data.MockDataHelper;
import dsalgo.library.TreeNode;
import dsalgo.library.TreeUtils;

/**
 * 
 * this class covers the implementation of following binary tree traversals -
 * 
 * 1. Level order tree traversal using queue
 * 
 * 2. Pre order traversal, both recursive and iterative way
 * 
 * 3. In order traversal, both recursive and iterative way
 * 
 * 4. Post order traversal, both recursive and iterative way
 *
 */
public class TreeTraversals {

	public static void main(String[] args) throws CloneNotSupportedException {

		TreeNode root = MockDataHelper.getBinaryTree();

		System.out.println("Level order traversal: ");
		TreeUtils.printLevelOrderTraversal(root);
		System.out.println("\n");

		System.out.println("Inorder traversal: ");
		System.out.print("recursive: ");
		TreeUtils.printInOrderTraversalRecursive(root);
		System.out.println("");
		System.out.print("iterative: ");
		TreeUtils.printInOrderTraversalIterative(root);
		System.out.println("\n");

		System.out.println("Preorder traversal: ");
		System.out.print("recursive: ");
		TreeUtils.printPreOrderTraversalRecursive(root);
		System.out.println("");
		System.out.print("iterative: ");
		TreeUtils.printPreOrderTraversalIterative(root);
		System.out.println("\n");

		System.out.println("Postorder traversal: ");
		System.out.print("recursive: ");
		TreeUtils.printPostOrderTraversalRecursive(root);
		System.out.println("");
		System.out.print("iterative: ");
		TreeUtils.printPostOrderTraversalIterative(root);
		System.out.println("\n");
	}

}
