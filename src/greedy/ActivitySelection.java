package greedy;

import java.util.HashMap;
import java.util.Map;

public class ActivitySelection {

  public static void main(String[] args) {
    int s[] = {1, 3, 0, 5, 8, 5};
    int f[] = {2, 4, 6, 7, 9, 9};
    int n = s.length;

//    List<Integer> list = Arrays.asList(0, 1, 3, 4);
//    list.forEach((index) -> {
//      System.out
//          .print("Start time: " + s[index.intValue()] + " Finish time: " + f[index.intValue()]);
//      System.out.println();
//    });
//    System.out.println("********************************");
    
    Map<Integer, Integer> indices = getMaxActivityCount(s, f, n);
    indices.forEach((key, value) -> {
      System.out.print("Start time: " + key.intValue() + " Finish time: " + value.intValue());
      System.out.println();
    });
  }

  public static Map<Integer, Integer> getMaxActivityCount(int[] s, int[] f, int n) {
    Map<Integer, Integer> indices = new HashMap<Integer, Integer>();

    // Sort by finish time
    for (int i = 0; i < n - 1; i++) {
      for (int k = i + 1; k < n; k++) {
        if (f[i] > f[k]) {
          int temp1 = s[i];
          int temp2 = f[i];
          s[i] = s[k];
          f[i] = f[k];
          s[k] = temp1;
          f[k] = temp2;
        }
      }
    }

    int lastSelectedActivity = 0;
    indices.put(s[0], f[0]);
    for (int p = 1; p < n; p++) {
      if (s[p] >= f[lastSelectedActivity]) {
        indices.put(s[p], f[p]);
        lastSelectedActivity = p;
      }
    }

    return indices;
  }

}
