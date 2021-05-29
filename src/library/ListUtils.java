package library;

public class ListUtils {

  public static void printList(String printIt, SinglyLinkedListNode root) {

    if (printIt != null) {
      System.out.print(printIt);
    }
    while (root != null) {
      System.out.print(root.getValue() + " -> ");
      root = root.getNext();
    }
  }

  public static SinglyLinkedListNode buildLinkedListFromArray(int[] array) {
    SinglyLinkedListNode root = null;
    for (int i = 0; i < array.length; i++) {
      SinglyLinkedListNode node = new SinglyLinkedListNode(array[i], root);
      root = node;
    }
    return root;
  }

  public static int getListSize(SinglyLinkedListNode head) {
    int size = 0;
    while (head != null) {
      size++;
      head = head.getNext();
    }
    return size;
  }
}
