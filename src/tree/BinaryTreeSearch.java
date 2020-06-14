package tree;

import library.TreeNode;

public class BinaryTreeSearch {

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

    boolean valueFound = searchValue(node1, 7);

    if (valueFound) {

      System.out.print("Value found in tree");
    } else {

      System.out.print("Value not found in tree");
    }
  }

  public static boolean searchValue(TreeNode root, int valueToSearch) {

    if (root == null) {
      return false;
    } else {

      if (root.getValue() == valueToSearch) {
        return true;
      }

      boolean valueFoundOnLeft = searchValue(root.getLeftChild(), valueToSearch);

      if (valueFoundOnLeft) {
        return true;
      }

      boolean valueFoundOnRight = searchValue(root.getRightChild(), valueToSearch);

      if (valueFoundOnRight) {
        return true;
      }

      return false;
    }
  }

}
