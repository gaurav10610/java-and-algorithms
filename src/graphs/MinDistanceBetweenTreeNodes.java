package graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import library.GraphUtils;
import library.MyQueue;
import library.TreeNode;
import library.TreeUtils;

/**
 * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
 * 
 * @author Gaurav
 *
 */
public class MinDistanceBetweenTreeNodes {

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    TreeNode root = TreeUtils.buildBinaryTreeFromArray(array, 0, -1);

    System.out.println("Minimum distance is " + getMinDistance(array, 10, 15));
  }

  public static int getMinDistance(int[] array, int node1, int node2) {
    return -1;
  }

  public static int findNodeIndex(int nodeValue, int[] treeArray) {

    return -1;
  }

}
