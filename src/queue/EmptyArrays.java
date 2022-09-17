package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class EmptyArrays {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer.parseInt(br.readLine());
    int totalTime = 0;

    String[] a = br.readLine().split(" ");
    String[] b = br.readLine().split(" ");

    Queue<String> queueA = new LinkedList<String>();
    Arrays.stream(a).forEach(value -> queueA.add(value));

    Queue<String> queueB = new LinkedList<String>();
    Arrays.stream(b).forEach(value -> queueB.add(value));


    while (!queueA.isEmpty()) {

      if (queueA.peek().equals(queueB.peek())) {
        queueA.poll();
        queueB.poll();
        totalTime++;
        continue;
      }

      rotateQueue(queueA);
      totalTime++;
    }

    System.out.print(totalTime);
  }

  public static void rotateQueue(Queue<String> queue) {
    if (!queue.isEmpty()) {
      String value = queue.poll();
      queue.add(value);
    }
  }

  public static void printQueue(Queue<String> queue) {
    System.out.println(queue);
  }

}
