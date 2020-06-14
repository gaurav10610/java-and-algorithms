package tree;

import java.util.Stack;
import library.TreeNode;
import library.TreeUtils;

/**
 * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
 * 
 * @author Gaurav
 *
 */
public class MinDistanceBetweenTwoNodesInTree {

  public static void main(String[] args) {

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

    int nodeValue1 = 8;
    int nodeValue2 = 10;

    Stack<TreeNode> rootToNode1Path = new Stack<TreeNode>();

    boolean isNode1Found = TreeUtils.findNodePathFromRoot(node1, nodeValue1, rootToNode1Path);

    if (!isNode1Found) {
      System.out.println("Node1 not found");
      return;
    }

    Stack<TreeNode> rootToNode2Path = new Stack<TreeNode>();

    boolean isNode2Found = TreeUtils.findNodePathFromRoot(node1, nodeValue2, rootToNode2Path);

    if (!isNode2Found) {
      System.out.println("Node2 not found");
      return;
    }

    TreeNode lca = TreeUtils.findLowestCommonAncestor(node1, nodeValue1, nodeValue2,
        rootToNode1Path, rootToNode2Path);

    if (lca == null) {
      System.out.println("Lowest Common Ancestor not found");
      return;
    }

    Stack<TreeNode> rootToLcaPath = new Stack<TreeNode>();
    TreeUtils.findNodePathFromRoot(node1, lca.getValue(), rootToLcaPath);

    int minimumDistance =
        rootToNode1Path.size() - 1 + rootToNode2Path.size() - 1 - 2 * (rootToLcaPath.size() - 1);

    System.out.println("Minimum distance between nodes " + nodeValue1 + " and " + nodeValue2
        + " is: " + minimumDistance);
  }

}
