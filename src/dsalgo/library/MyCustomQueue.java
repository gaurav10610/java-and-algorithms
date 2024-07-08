package dsalgo.library;

/**
 * 
 * custom impementation of capacity based queue using array
 *
 */
public class MyCustomQueue {

  private int size;
  private Object[] queue;
  private int front;
  private int rear;

  public MyCustomQueue(int size) {
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

  public boolean enqueue(Object object) {

    boolean isObjectAdded = false;

    if (isFull()) {
      isObjectAdded = false;
    } else {

      // when queue is empty
      if (isEmpty()) {
        rear = 0;
        front = 0;
      } else {

        // when queue is not empty
        rear++;
      }
      queue[rear] = object;
      isObjectAdded = true;
    }
    return isObjectAdded;
  }

  public Object dequeue() {
    Object object = null;

    if (!isEmpty()) {
      object = queue[front];

      // when there was only one element in the queue
      if (front == rear) {
        front = -1;
        rear = -1;
      } else {

        // when there was more than one element in the queue
        front++;
      }
    }
    return object;
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
