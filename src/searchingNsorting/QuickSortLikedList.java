package searchingNsorting;

import library.SinglyLinkedListNode;
import library.ListUtils;

/**
 * Incomplete 
 * @author Gaurav
 *
 */
public class QuickSortLikedList {
  static int[] array = {12, 11, 13, 5, 6, 7};
  static SinglyLinkedListNode root = null;

  public static void main(String[] args) {
    root = ListUtils.buildLinkedListFromArray(array);
    // ListUtils.printList(root);
    listQuickSort(root, 0, array.length - 1);
    System.out.println(root);
  }

  public static void listQuickSort(SinglyLinkedListNode node, int start, int end) {
    int i = partitionList(node, start, end);
    if (start < i)
      listQuickSort(node, start, i - 1);
    if (end > i)
      listQuickSort(node, i + 1, end);
  }

  public static int partitionList(SinglyLinkedListNode node, int start, int end) {
    int i = 0;
    SinglyLinkedListNode pivoteNode = null;

    if (i == 0) {
      pivoteNode = node;
    } else {
      while (i < start) {
        node = node.getNext();
        i++;
      }
    }
    pivoteNode = node;
    SinglyLinkedListNode iNode = pivoteNode;
    SinglyLinkedListNode iteratorNode = pivoteNode.getNext();
    int pivotValue = pivoteNode.getValue();
    int j = i + 1;

    while ((j <= end) && iteratorNode != null) {
      if (pivotValue >= iteratorNode.getValue()) {
        i++;
        SinglyLinkedListNode tempNode = iNode.getNext().getNext();
        iNode.getNext().setNext(iteratorNode.getNext());
        iNode.setNext(iteratorNode);
        iteratorNode.setNext(tempNode);
        iNode = iNode.getNext();
      }
      iteratorNode = iteratorNode.getNext();
      j++;
    }

    return i + 1;
  }

  // swap
  private static void swapNodes(SinglyLinkedListNode nodeA, SinglyLinkedListNode nodeB) {

  }

}
