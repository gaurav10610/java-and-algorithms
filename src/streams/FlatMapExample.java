package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FlatMapExample {

  public static void main(String[] args) {

    List<List<Integer>> listOfList = new ArrayList<>();

    List.of(1, 2, 3, 4, 5).stream().forEach(value -> listOfList.add(Arrays.asList(1, 2, 3, 4, 5)));

    Optional<Integer> sumOptional =
        listOfList.stream().flatMap(List::stream).reduce((number1, number2) -> number1 + number2);

    sumOptional.ifPresent(result -> System.out.print(result));
  }

}
