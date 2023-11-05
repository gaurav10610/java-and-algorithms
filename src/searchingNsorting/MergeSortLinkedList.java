package searchingNsorting;

import library.SinglyLinkedListNode;
import library.ListUtils;

public class MergeSortLinkedList {

	public static void main(String[] args) {
		int[] array = { 12, 11, 13, 5, 6, 7 };
		SinglyLinkedListNode head = ListUtils.buildLinkedListFromArray(array);
		System.out.println(head);
		System.out.println("Sorted List: " + mergeSort(head).toString());
	}

	/**
	 * Merge sort
	 * 
	 * @param head
	 * @return
	 */
	public static SinglyLinkedListNode mergeSort(SinglyLinkedListNode head) {
		if (head == null || (head != null && head.getNext() == null)) {
			return head;
		} else {
			int mid = ListUtils.getListSize(head) / 2;
			SinglyLinkedListNode mideNode = breakListByIndex(head, mid);
			SinglyLinkedListNode left = mergeSort(head);
			SinglyLinkedListNode right = mergeSort(mideNode);
			return sortedMerge(left, right);
		}
	}

	/**
	 * Merging sorted lists
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static SinglyLinkedListNode sortedMerge(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		System.out.println("Merging lists: " + head1 + " & " + head2);
		SinglyLinkedListNode sortedList = null;
		SinglyLinkedListNode sortedPointer = sortedList;
		while (head1 != null && head2 != null) {

			if (head1.getValue() <= head2.getValue()) {

				if (sortedList == null) {
					sortedList = new SinglyLinkedListNode(head1.getValue(), null);
					head1 = head1.getNext();
					sortedPointer = sortedList;
				} else {
					sortedPointer.setNext(new SinglyLinkedListNode(head1.getValue(), null));
					head1 = head1.getNext();
					sortedPointer = sortedPointer.getNext();
				}
			} else {

				if (sortedList == null) {
					sortedList = new SinglyLinkedListNode(head2.getValue(), null);
					head2 = head2.getNext();
					sortedPointer = sortedList;
				} else {
					sortedPointer.setNext(new SinglyLinkedListNode(head2.getValue(), null));
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
				sortedList = new SinglyLinkedListNode(head1.getValue(), null);
				head1 = head1.getNext();
				sortedPointer = sortedList;
			} else {
				sortedPointer.setNext(new SinglyLinkedListNode(head1.getValue(), null));
				head1 = head1.getNext();
				sortedPointer = sortedPointer.getNext();
			}
		}

		/**
		 * If elements are left in second sorted list
		 */
		while (head2 != null) {
			if (sortedList == null) {
				sortedList = new SinglyLinkedListNode(head2.getValue(), null);
				head2 = head2.getNext();
				sortedPointer = sortedList;
			} else {
				sortedPointer.setNext(new SinglyLinkedListNode(head2.getValue(), null));
				head2 = head2.getNext();
				sortedPointer = sortedPointer.getNext();
			}
		}
		System.out.println("Merged list: " + sortedList);
		return sortedList;
	}

	public static SinglyLinkedListNode breakListByIndex(SinglyLinkedListNode head1, int mid) {
		SinglyLinkedListNode node = null;
		SinglyLinkedListNode pointerHead = head1;
		while (mid > 1) {
			pointerHead = pointerHead.getNext();
			mid--;
		}
		node = pointerHead.getNext();
		pointerHead.setNext(null);
		return node;
	}
}
