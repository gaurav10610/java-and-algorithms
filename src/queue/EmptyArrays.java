package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given two arrays each of size , and consisting of the first positive integers each
 * exactly once, that is, they are permutations.
 * 
 * Your task is to find the minimum time required to make both the arrays empty. The following two
 * types of operations can be performed any number of times each taking 1 second:
 * 
 * 1. In the first operation, you are allowed to rotate the first array clockwise.
 * 
 * 2. In the second operation, when the first element of both the arrays is the same, they are
 * removed from both the arrays and the process continues.
 * 
 * Example -
 * 
 * Input -
 * 
 * Array1 - 1 3 2
 * 
 * Array2 - 2 3 1
 *
 * Output - 6
 */
public class EmptyArrays {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
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
