package stack;

import library.DoublyLinkedListNode;

/**
 * Design a stack using queue and implement following methods -
 * 
 * 1) push() which adds an element to the top of stack.
 * 
 * 2) pop() which removes an element from top of stack.
 * 
 * 3) findMiddle() which will return middle element of the stack.
 * 
 * 4) deleteMiddle() which will delete the middle element.
 *
 * NOTE - All above mentioned methods should be of O(1) time complexity
 * 
 */
public class StackUsingLinkedListWithGetMid {

	public static void main(String[] args) {
		StackWithGetMid stack = new StackWithGetMid();
		stack.push(11);
		stack.push(22);
		stack.push(33);
		stack.push(44);
		stack.push(55);
		stack.push(66);
		stack.push(77);

		System.out.println(stack.toString());
		System.out.println("Item popped is " + stack.pop());
		System.out.println(stack.toString());
		System.out.println("Item popped is " + stack.pop());
		System.out.println(stack.toString());
		System.out.println("Middle element " + stack.findMiddle() + " is deleted");
		stack.deleteMiddle();
		System.out.println(stack.toString());
		System.out.println("Middle element " + stack.findMiddle() + " is deleted");
		stack.deleteMiddle();
		System.out.println(stack.toString());
	}
}

class StackWithGetMid {

	private DoublyLinkedListNode<Integer> head;
	private DoublyLinkedListNode<Integer> midNode;
	private DoublyLinkedListNode<Integer> topNode;
	private int size;

	public StackWithGetMid() {
		this.size = 0;
	}

	public void push(Integer element) {
		DoublyLinkedListNode<Integer> node = new DoublyLinkedListNode<>(element, null, topNode);

		// if pushed element is the first element in stack
		if (isEmpty()) {
			head = node;
			midNode = node;
			topNode = node;
		} else {

			// update the top node reference
			topNode.setNext(node);
			topNode = topNode.getNext();

			// update the mid node reference if required
			if (size % 2 == 0) {
				midNode = midNode.getNext();
			}
		}
		size++;
	}

	public Integer pop() {

		if (isEmpty())
			return null;

		if (size == 1) {
			head = null;
			topNode = null;
			midNode = null;
			size--;
			return head.getValue();
		} else {

			if (size % 2 != 0) {
				midNode = midNode.getPrevious();
			}
			size--;
			Integer value = topNode.getValue();
			topNode = topNode.getPrevious();
			topNode.setNext(null);
			return value;
		}
	}

	public Integer findMiddle() {
		if (isEmpty())
			return null;
		return midNode.getValue();
	}

	public boolean deleteMiddle() {
		if (isEmpty())
			return false;

		if (size == 1) {
			head = null;
			topNode = null;
			midNode = null;
		} else {

			// update the reference of previous and next nodes of mid node
			midNode.getNext().setPrevious(midNode.getPrevious());
			midNode.getPrevious().setNext(midNode.getNext());

			// update the mid node reference appropriately basis on stack size
			if (size % 2 == 0) {
				midNode = midNode.getNext();
			} else {
				midNode = midNode.getPrevious();
			}
		}
		size--;
		return true;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		return "[list: " + this.head.toString() + "] [midNode: " + this.midNode.getValue() + "]";
	}
}
