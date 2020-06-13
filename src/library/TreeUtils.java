package library;

public class TreeUtils {

  public static TreeNode buildBinaryTreeFromArray(int[] array, int i, int blankInteger) {

    TreeNode node = null;

    // Base case for recursion
    if (i < array.length && array[i] != blankInteger) {
      node = new TreeNode(array[i]);

      // insert left child
      node.setLeftChild(buildBinaryTreeFromArray(array, (2 * i + 1), blankInteger));

      // insert right child
      node.setRightChild(buildBinaryTreeFromArray(array, (2 * i + 2), blankInteger));
    }
    return node;
  }

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
}
