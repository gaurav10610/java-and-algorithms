package library;

import java.io.*;
import java.util.*;

public class FastReader {
  
  BufferedReader br;
  StringTokenizer st;
  String delimeter;


  /**
   * @param delimeter : separator used
   */
  public FastReader(String delimeter) {
    br = new BufferedReader(new InputStreamReader(System.in));
    this.delimeter = delimeter;
  }

  public String next() {
    while (st == null || !st.hasMoreElements()) {
      try {
        st = new StringTokenizer(br.readLine(), delimeter);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return st.nextToken();
  }

  public int nextInt() {
    return Integer.parseInt(next());
  }

  public long nextLong() {
    return Long.parseLong(next());
  }

  public double nextDouble() {
    return Double.parseDouble(next());
  }

  public String nextLine() {
    String str = "";
    try {
      str = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return str;
  }
}
