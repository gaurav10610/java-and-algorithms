package tree;

import library.TreeNode;

public class CheckIfABinaryTreeIsHeap {

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

    if (checkIfMaxHeap(node1)) {
      System.out.println("Yes, tree is a max heap");
    } else {
      System.out.println("No, tree is not a max heap");
    }

    if (checkIfMinHeap(node1)) {
      System.out.println("Yes, tree is a min heap");
    } else {
      System.out.println("No, tree is not a min heap");
    }
  }

  /**
   * Check if given binary tree is max heap or not
   * 
   * @param root
   * @return
   */
  public static boolean checkIfMaxHeap(TreeNode root) {

    if (root == null
        || (root != null && root.getLeftChild() == null && root.getRightChild() == null)) {
      return true;
    } else {

      if ((root.getLeftChild() != null && root.getLeftChild().getValue() > root.getValue())
          || (root.getRightChild() != null && root.getRightChild().getValue() > root.getValue())) {
        return false;
      } else {
        return checkIfMaxHeap(root.getLeftChild()) && checkIfMaxHeap(root.getRightChild());
      }
    }
  }

  /**
   * Check if given binary tree is min heap or not
   * 
   * @param root
   * @return
   */
  public static boolean checkIfMinHeap(TreeNode root) {

    if (root == null
        || (root != null && root.getLeftChild() == null && root.getRightChild() == null)) {
      return true;
    } else {

      if ((root.getLeftChild() != null && root.getLeftChild().getValue() < root.getValue())
          || (root.getRightChild() != null && root.getRightChild().getValue() < root.getValue())) {
        return false;
      } else {
        return checkIfMinHeap(root.getLeftChild()) && checkIfMinHeap(root.getRightChild());
      }
    }
  }
}
