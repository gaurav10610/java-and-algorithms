package tree;

import java.util.Stack;
import library.TreeNode;

public class FindLowestCommonAncestorInTree {

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

    int nodeValue1 = 6;

    int nodeValue2 = 9;

    TreeNode lca = findLowestCommonAncestor(node1, nodeValue1, nodeValue2);

    if (lca != null) {

      System.out.println("Lowest Common Ancestor of nodes with values: " + nodeValue1 + " and "
          + nodeValue2 + " is: " + lca.getValue());
    }
  }

  public static TreeNode findLowestCommonAncestor(TreeNode root, int nodeValue1, int nodeValue2) {

    TreeNode lca = null;

    Stack<TreeNode> stack1 = new Stack<TreeNode>();

    boolean isNode1Found = findNodePathFromRoot(root, nodeValue1, stack1);

    Stack<TreeNode> stack2 = new Stack<TreeNode>();

    boolean isNode2Found = findNodePathFromRoot(root, nodeValue2, stack2);

    if (isNode1Found && isNode2Found) {

      System.out.println("Node1 path: " + stack1.toString());

      System.out.println("Node2 path: " + stack2.toString());

      int i = 0;
      while (i < stack1.size() && i < stack2.size()) {

        if (stack1.get(i).getValue() == stack2.get(i).getValue()) {

          lca = stack1.get(i);
        } else {

          break;
        }
        i++;
      }
    } else {

      System.out.println("No lowest common ansector found");
    }

    return lca;
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

}
