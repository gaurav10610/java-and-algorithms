package library;

public class MyQueue {

  private int size;
  private Object[] queue;
  private int front;
  private int rear;

  public MyQueue(int size) {
    this.size = size;
    front = -1;
    rear = -1;
    queue = new Object[size];
  }

  public boolean isEmpty() {
    return rear == -1;
  }

  public boolean isFull() {
    return front == 0 && rear == size - 1;
  }

  public boolean enqueue(Object obj) {

    if (rear == -1) {
      rear = 0;
      front = 0;
      queue[rear] = obj;
      return true;
    } else if (isFull()) {
      return false;
    } else {
      rear++;
      queue[rear] = obj;
      return true;
    }
  }

  public Object dequeue() {
    if (isEmpty()) {
      return null;
    } else {
      Object object = queue[front];
      if (front == rear) {
        front = -1;
        rear = -1;
      } else {
        front++;
      }
      return object;
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("");
    Object value = this.dequeue();
    while (value != null) {
      sb.append(value);
    }
    return sb.toString();
  }

}
