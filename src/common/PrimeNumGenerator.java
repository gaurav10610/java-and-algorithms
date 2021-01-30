package common;

import java.io.IOException;

public class PrimeNumGenerator {

  public static void main(String[] args) throws NumberFormatException, IOException {
    int N = 100;
    generatePrimes(N);
  }

  public static void generatePrimes(int N) {

    boolean[] crossArray = new boolean[N + 1];

    for (int i = 2; i <= N; i++) {

      if (!crossArray[i]) {

        int p = i;
        int k = 2;
        int j = p * k;

        while (j <= N) {
          crossArray[j] = true;
          k++;
          j = p * k;
        }
        System.out.print(i + " ");
      }
    }
  }
}
