package streams;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {

  public static void main(String[] args) {

    List<Integer> row1 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> row2 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> row3 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> row4 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> row5 = Arrays.asList(1, 2, 3, 4, 5);

    List<List<Integer>> listOfList = Arrays.asList(row1, row2, row3, row4, row5);

    Integer sum = listOfList.stream().flatMap(list -> list.stream())
        .reduce((number1, number2) -> number1 + number2).get();
    
    System.out.println(sum);
  }

}
