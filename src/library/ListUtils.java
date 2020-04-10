package library;

public class ListUtils {

  public static void printList(String printIt, ListNode root) {

    if (printIt != null) {
      System.out.print(printIt);
    }
    while (root != null) {
      System.out.print(root.getValue() + " -> ");
      root = root.getNext();
    }
  }

  public static ListNode buildLinkedListFromArray(int[] array) {
    ListNode root = null;
    for (int i = 0; i < array.length; i++) {
      ListNode node = new ListNode(array[i], root);
      root = node;
    }
    return root;
  }

  public static int getListSize(ListNode head) {
    int size = 0;
    while (head != null) {
      size++;
      head = head.getNext();
    }
    return size;
  }
}
