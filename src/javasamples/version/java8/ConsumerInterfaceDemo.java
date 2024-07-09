package javasamples.version.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ConsumerInterfaceDemo {

    /**
     * consumer for printing each element of list
     */
    private final static Consumer<List<Integer>> printListConsumer = System.out::print;

    /**
     * consumer for sorting list in reverse order
     */
    private final static Consumer<List<Integer>> sortingConsumer = list -> list.sort(Collections.reverseOrder());

    /**
     * list supplier
     */
    private final static Supplier<List<Integer>> listSupplier = () -> new ArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public static void main(String[] args) {
        List<Integer> list = listSupplier.get();

        /*
         * consumer for updating each element in list with it's multiple of 2
         */
        Consumer<List<Integer>> updateListConsumer = listArg -> {
            IntStream.range(0, listArg.size()).forEach(i -> listArg.set(i, listArg.get(i) * 2));
        };

        // call the consumers one after another
        updateListConsumer.andThen(sortingConsumer).andThen(printListConsumer).accept(list);
    }

}
