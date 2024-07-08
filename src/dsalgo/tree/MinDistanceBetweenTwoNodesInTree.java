package dsalgo.tree;

import java.util.Stack;
import dsalgo.data.MockDataHelper;
import dsalgo.library.TreeNode;
import dsalgo.library.TreeUtils;

/**
 * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
 * 
 * @author Gaurav
 *
 */
public class MinDistanceBetweenTwoNodesInTree {

	public static void main(String[] args) {

		TreeNode root = MockDataHelper.getBinaryTree();

		int nodeValue1 = 8;
		int nodeValue2 = 10;

		Stack<TreeNode> rootToNode1Path = new Stack<TreeNode>();

		boolean isNode1Found = TreeUtils.findNodePathFromRoot(root, nodeValue1, rootToNode1Path);

		if (!isNode1Found) {
			System.out.println("Node1 not found");
			return;
		}

		Stack<TreeNode> rootToNode2Path = new Stack<TreeNode>();

		boolean isNode2Found = TreeUtils.findNodePathFromRoot(root, nodeValue2, rootToNode2Path);

		if (!isNode2Found) {
			System.out.println("Node2 not found");
			return;
		}

		TreeNode lca = TreeUtils.findLowestCommonAncestor(root, nodeValue1, nodeValue2, rootToNode1Path,
				rootToNode2Path);

		if (lca == null) {
			System.out.println("Lowest Common Ancestor not found");
			return;
		}

		Stack<TreeNode> rootToLcaPath = new Stack<TreeNode>();
		TreeUtils.findNodePathFromRoot(root, lca.getValue(), rootToLcaPath);

		int minimumDistance = rootToNode1Path.size() - 1 + rootToNode2Path.size() - 1 - 2 * (rootToLcaPath.size() - 1);

		System.out.printf("Minimum distance between nodes %d and %d is: %d", nodeValue1, nodeValue2, minimumDistance);
	}

}
