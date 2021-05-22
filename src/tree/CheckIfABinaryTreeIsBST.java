package tree;

import java.util.ArrayList;
import java.util.List;
import data.MockDataHelper;
import library.TreeNode;

/**
 * 
 * Check if the given binary tree is a binary search tree or not
 *
 */
public class CheckIfABinaryTreeIsBST {

  public static void main(String[] args) {
    List<TreeNode> inputs = new ArrayList<>();

    inputs.add(MockDataHelper.getBinaryTree());
    inputs.add(MockDataHelper.getBST());
    inputs.add(getGreaterValueOnLeftEdgeCase());
    inputs.add(getSmallerValueOnRightEdgeCase());

    int i = 1;
    for (TreeNode root : inputs) {
      boolean isBST = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
      if (isBST)
        System.out.println("tree " + i + " is BST");
      else
        System.out.println("tree " + i + " is not BST");
      i++;
    }
  }

  public static boolean isBST(TreeNode node, int min, int max) {

    if (node == null) {

      /**
       * 
       * empty tree is always BST
       */
      return true;
    } else if (node.getLeftChild() == null && node.getRightChild() == null) {

      /**
       * 
       * for leaf node, need to check the max and min value bounds
       */
      if (node.getValue() >= min && node.getValue() <= max) {
        return true;
      } else {

        /**
         * 
         * violation of max or min value bounds
         */
        return false;
      }
    } else {

      boolean isLeftSubtreeBST = true;
      boolean isRightSubtreeBST = true;

      /**
       * 
       * recursively check if left subtree is BST or not with appropriate min and max value bounds
       */
      if (node.getLeftChild() != null) {
        isLeftSubtreeBST = isBST(node.getLeftChild(), min, node.getValue() - 1);
      }

      /**
       * 
       * recursively check if right subtree is BST or not with appropriate min and max value bounds
       */
      if (node.getRightChild() != null) {
        isRightSubtreeBST = isBST(node.getRightChild(), node.getValue(), max);
      }

      /**
       * return true if both the subtrees are BST
       */
      return isLeftSubtreeBST && isRightSubtreeBST;
    }
  }

  /**
   * 
   * edge case input
   */
  public static TreeNode getGreaterValueOnLeftEdgeCase() {
    TreeNode node1 = new TreeNode(1);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node8 = new TreeNode(8);
    TreeNode node10 = new TreeNode(10);

    node6.setLeftChild(node4);
    node6.setRightChild(node8);
    node4.setLeftChild(node3);
    node4.setRightChild(node5);
    node3.setLeftChild(node1);
    node3.setRightChild(node10);
    return node6;
  }

  /**
   * 
   * edge case input
   */
  public static TreeNode getSmallerValueOnRightEdgeCase() {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node8 = new TreeNode(8);

    node6.setLeftChild(node4);
    node6.setRightChild(node8);
    node4.setLeftChild(node3);
    node4.setRightChild(node5);
    node3.setLeftChild(node1);
    node8.setLeftChild(node2);
    return node6;
  }

}
