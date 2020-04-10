package library;

public class ListNode {
  private int value;
  private ListNode next;

  public ListNode(int value, ListNode next) {
    this.value = value;
    this.next = next;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return this.value + "->" + (this.next != null ? this.next : "");
  }

}
