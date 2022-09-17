package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceDemo {

  /**
   * consumer for printing each element of list
   */
  static Consumer<List<Integer>> printListConsumer =
      listArg -> System.out.print(Arrays.toString(listArg.toArray()));

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    /**
     * consumer for updating each element in list with it's multiple of 2
     */
    Consumer<List<Integer>> updateListConsumer = listArg -> {
      for (int i = 0; i < listArg.size(); i++) {
        listArg.set(i, list.get(i) * 2);
      }
    };

    // call the consumers one after another
    updateListConsumer.andThen(printListConsumer).accept(list);
  }

}
