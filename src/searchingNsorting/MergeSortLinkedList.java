package searchingNsorting;

import library.ListNode;
import library.ListUtils;

public class MergeSortLinkedList {

  public static void main(String[] args) {
    int[] array = {12, 11, 13, 5, 6, 7};
    ListNode head = ListUtils.buildLinkedListFromArray(array);
    ListUtils.printList("Unsorted List: ", head);
    System.out.println();
    ListUtils.printList("Sorted List: ", mergeSort(head));
  }

  /**
   * Merge sort
   * @param head
   * @return
   */
  public static ListNode mergeSort(ListNode head) {
    if (head == null || (head != null && head.getNext() == null)) {
      return head;
    } else {
      int mid = ListUtils.getListSize(head) / 2;
      ListNode mideNode = breakListByIndex(head, mid);
      ListNode left = mergeSort(head);
      ListNode right = mergeSort(mideNode);
      return sortedMerge(left, right);
    }
  }

  /**
   * Merging sorted lists
   * @param head1
   * @param head2
   * @return
   */
  public static ListNode sortedMerge(ListNode head1, ListNode head2) {
    System.out.println("Merging lists: " + head1 + " & " + head2);
    ListNode sortedList = null;
    ListNode sortedPointer = sortedList;
    while (head1 != null && head2 != null) {

      if (head1.getValue() <= head2.getValue()) {

        if (sortedList == null) {
          sortedList = new ListNode(head1.getValue(), null);
          head1 = head1.getNext();
          sortedPointer = sortedList;
        } else {
          sortedPointer.setNext(new ListNode(head1.getValue(), null));
          head1 = head1.getNext();
          sortedPointer = sortedPointer.getNext();
        }
      } else {

        if (sortedList == null) {
          sortedList = new ListNode(head2.getValue(), null);
          head2 = head2.getNext();
          sortedPointer = sortedList;
        } else {
          sortedPointer.setNext(new ListNode(head2.getValue(), null));
          head2 = head2.getNext();
          sortedPointer = sortedPointer.getNext();
        }
      }
    }

    /**
     * If elements are left in first sorted list
     */
    while (head1 != null) {
      if (sortedList == null) {
        sortedList = new ListNode(head1.getValue(), null);
        head1 = head1.getNext();
        sortedPointer = sortedList;
      } else {
        sortedPointer.setNext(new ListNode(head1.getValue(), null));
        head1 = head1.getNext();
        sortedPointer = sortedPointer.getNext();
      }
    }

    /**
     * If elements are left in second sorted list
     */
    while (head2 != null) {
      if (sortedList == null) {
        sortedList = new ListNode(head2.getValue(), null);
        head2 = head2.getNext();
        sortedPointer = sortedList;
      } else {
        sortedPointer.setNext(new ListNode(head2.getValue(), null));
        head2 = head2.getNext();
        sortedPointer = sortedPointer.getNext();
      }
    }
    System.out.println("Merged list: " + sortedList);
    return sortedList;
  }

  public static ListNode breakListByIndex(ListNode head1, int mid) {
    ListNode node = null;
    ListNode pointerHead = head1;
    while (mid > 1) {
      pointerHead = pointerHead.getNext();
      mid--;
    }
    node = pointerHead.getNext();
    pointerHead.setNext(null);
    return node;
  }
}
