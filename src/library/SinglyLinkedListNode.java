package library;

public class SinglyLinkedListNode implements Cloneable {
  private int value;
  private SinglyLinkedListNode next;

  public SinglyLinkedListNode(int value, SinglyLinkedListNode next) {
    this.value = value;
    this.next = next;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public SinglyLinkedListNode getNext() {
    return next;
  }

  public void setNext(SinglyLinkedListNode next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return this.value + "->" + (this.next != null ? this.next.toString() : "null");
  }

  @Override
  public SinglyLinkedListNode clone() {
    SinglyLinkedListNode node = new SinglyLinkedListNode(value, next != null ? next.clone() : null);
    return node;
  }

}
