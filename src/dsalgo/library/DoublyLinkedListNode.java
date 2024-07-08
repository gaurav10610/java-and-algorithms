package dsalgo.library;

/**
 * 
 * this is a list node implementation for doubly linked list
 *
 */
public class DoublyLinkedListNode<T> implements Cloneable {
	private T value;
	private DoublyLinkedListNode<T> next;
	private DoublyLinkedListNode<T> previous;

	public DoublyLinkedListNode(T value, DoublyLinkedListNode<T> next, DoublyLinkedListNode<T> previous) {
		super();
		this.value = value;
		this.next = next;
		this.previous = previous;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public DoublyLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(DoublyLinkedListNode<T> next) {
		this.next = next;
	}

	public DoublyLinkedListNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyLinkedListNode<T> previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return (this.previous == null ? "null" : "") + " <-" + this.value + "-> "
				+ (this.next != null ? this.next.toString() : "null");
	}

	@Override
	public DoublyLinkedListNode<T> clone() {
		DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(value, next != null ? next.clone() : null,
				previous != null ? previous.clone() : null);
		return node;
	}
}
