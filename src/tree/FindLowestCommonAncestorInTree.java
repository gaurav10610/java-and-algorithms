package tree;

import java.util.Stack;
import data.MockDataHelper;
import library.TreeNode;
import library.TreeUtils;

public class FindLowestCommonAncestorInTree {

  public static void main(String[] args) {

    TreeNode root = MockDataHelper.getBinaryTree();

    int nodeValue1 = 4;

    int nodeValue2 = 9;

    Stack<TreeNode> rootToNode1Path = new Stack<TreeNode>();

    boolean isNode1Found = TreeUtils.findNodePathFromRoot(root, nodeValue1, rootToNode1Path);

    if (!isNode1Found) {
      System.out.println("Node1 not found");
      return;
    }

    Stack<TreeNode> rootToNode2Path = new Stack<TreeNode>();

    boolean isNode2Found = TreeUtils.findNodePathFromRoot(root, nodeValue2, rootToNode2Path);

    if (!isNode2Found) {
      System.out.println("Node2 not found");
      return;
    }

    TreeNode lca = TreeUtils.findLowestCommonAncestor(root, nodeValue1, nodeValue2,
        rootToNode1Path, rootToNode2Path);

    if (lca != null) {

      System.out.println("Lowest Common Ancestor of nodes with values: " + nodeValue1 + " and "
          + nodeValue2 + " is: " + lca.getValue());
    } else {

      System.out.println("Lowest Common Ancestor not found");
    }
  }


}
