package library;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeUtils {

  // Function to print tree nodes in InOrder fashion
  public static void printInOrderTraversal(TreeNode root) {
    if (root != null) {
      printInOrderTraversal(root.getLeftChild());
      System.out.print(root.getValue() + " ");
      printInOrderTraversal(root.getRightChild());
    }
  }

  public static void printPreOrderTraversal(TreeNode root) {
    if (root != null) {
      System.out.print(root.getValue() + " ");
      printPreOrderTraversal(root.getLeftChild());
      printPreOrderTraversal(root.getRightChild());
    }
  }

  public static void printPostOrderTraversal(TreeNode root) {
    if (root != null) {
      printPostOrderTraversal(root.getLeftChild());
      printPostOrderTraversal(root.getRightChild());
      System.out.print(root.getValue() + " ");
    }
  }

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
