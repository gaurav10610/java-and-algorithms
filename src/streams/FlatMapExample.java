package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapExample {

  public static void main(String[] args) {

    List<List<Integer>> listOfList = new ArrayList<>();
    int i = 5;
    while (i >= 0) {
      listOfList.add(Arrays.asList(1, 2, 3, 4, 5));
      i++;
    }

    Integer sum = listOfList.stream().flatMap(List::stream)
        .reduce((number1, number2) -> number1 + number2).get();

    System.out.println(sum);
  }

}
