package tree;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import library.TreeNode;

/**
 * 
 * Print left and right projection of a binary tree
 *
 */
public class BinaryTreeLeftRightProjection {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(0);
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

    root.setRightChild(node1);
    root.setLeftChild(new TreeNode(100));

    node1.setLeftChild(node2);
    node1.setRightChild(node3);
    node2.setLeftChild(node4);
    node2.setRightChild(node5);
    node3.setLeftChild(node6);
    node3.setRightChild(node7);
    node5.setLeftChild(node8);
    node5.setRightChild(node9);
    node7.setLeftChild(node10);

    System.out.println("Left projection of the tree: ");
    printLeftProjection(root);
    System.out.println("\n");

    System.out.println("Right projection of the tree: ");
    printRightProjection(root);
  }

  public static void printLeftProjection(TreeNode root) {

    Map<Integer, Integer> level = new LinkedHashMap<Integer, Integer>();

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    level.put(root.getValue(), 0);

    while (!queue.isEmpty()) {

      TreeNode node = queue.poll();

      if (node.getLeftChild() != null) {

        level.put(node.getLeftChild().getValue(), level.get(node.getValue()) + 1);
        queue.add(node.getLeftChild());
      }
      if (node.getRightChild() != null) {

        level.put(node.getRightChild().getValue(), level.get(node.getValue()) + 1);
        queue.add(node.getRightChild());
      }
    }

    Set<Integer> set = new HashSet<Integer>();

    level.forEach((key, value) -> {

      if (!set.contains(value)) {

        System.out.println("(" + key + ")");
        set.add(value);
      }

    });
  }

  public static void printRightProjection(TreeNode root) {

    Map<Integer, Integer> level = new LinkedHashMap<Integer, Integer>();

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    level.put(root.getValue(), 0);

    while (!queue.isEmpty()) {

      TreeNode node = queue.poll();

      if (node.getRightChild() != null) {

        level.put(node.getRightChild().getValue(), level.get(node.getValue()) + 1);
        queue.add(node.getRightChild());
      }

      if (node.getLeftChild() != null) {

        level.put(node.getLeftChild().getValue(), level.get(node.getValue()) + 1);
        queue.add(node.getLeftChild());
      }
    }

    Set<Integer> set = new HashSet<Integer>();

    level.forEach((key, value) -> {

      if (!set.contains(value)) {

        System.out.println("(" + key + ")");
        set.add(value);
      }

    });
  }
}
