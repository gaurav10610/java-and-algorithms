package library;

public class TreeUtils {

  public static TreeNode buildBinaryTreeFromArray(int[] array, TreeNode root, int i) {
    // Base case for recursion
    if (i < array.length) {
      TreeNode temp = new TreeNode(array[i]);
      root = temp;

      // insert left child
      root.setLeftChild(buildBinaryTreeFromArray(array, root.getLeftChild(), 2 * i + 1));

      // insert right child
      root.setRightChild(buildBinaryTreeFromArray(array, root.getRightChild(), 2 * i + 2));
    }
    return root;
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
