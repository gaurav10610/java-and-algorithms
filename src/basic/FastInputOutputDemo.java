package basic;

import library.FastReader;

public class FastInputOutputDemo {

  public static void main(String[] args) {

    FastReader io = new FastReader(" ");
    int n = io.nextInt();
    int k = io.nextInt();
    int count = 0;
    while (n-- > 0) {
      int x = io.nextInt();
      if (x % k == 0)
        count++;
    }
    System.out.println(count);
  }
}
