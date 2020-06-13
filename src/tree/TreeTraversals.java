package tree;

import library.TreeNode;
import library.TreeUtils;

public class TreeTraversals {

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

    System.out.println("Inorder traversal: ");
    TreeUtils.printInOrderTraversal(node1);
    System.out.println();

    System.out.println("Preorder traversal: ");
    TreeUtils.printPreOrderTraversal(node1);
    System.out.println();

    System.out.println("Postorder traversal: ");
    TreeUtils.printPostOrderTraversal(node1);
    System.out.println();

    System.out.println("Levelorder traversal: ");
    TreeUtils.printLevelOrderTraversal(node1);
    System.out.println();
  }

}
