package tree;

import library.TreeNode;
import library.TreeUtils;

public class CheckIfABinaryTreeIsHeap {

  public static void main(String[] args) {
    int[] array = {97, 46, 37, 12, 3, 7, 31, 6, 9};
    TreeNode root = null;
    root = TreeUtils.buildBinaryTreeFromArray(array, root, 0);
    // TreeUtils.printPreOrderTraversal(root);
    
    if (checkIfMaxHeap(root)) {
      System.out.print("Yes, tree is a max heap");
    } else {
      System.out.print("No, tree is a max heap");
    }
  }

  /**
   * Check if given binary tree is max heap or not
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
        return (checkIfMaxHeap(root.getLeftChild()) && checkIfMaxHeap(root.getRightChild()));
      }
    }
  }
}
