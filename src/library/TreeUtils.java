package library;

import java.util.LinkedList;
import java.util.Queue;

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
}
