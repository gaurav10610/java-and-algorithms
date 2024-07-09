package javasamples.version.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableCollectionsDemo {

    public static void main(String[] args) {

        List<String> immutableList = List.of("Tony", "Steve", "Natasha");
        System.out.println(immutableList);

        Set<String> immutableSet = Set.of("Bruce", "Thor Odinson");
        System.out.println(immutableSet);

        Map<String, Integer> immutableMap = Map.ofEntries(Map.entry("Arya", 1), Map.entry("Sansa", 2),
                Map.entry("Jon", 3), Map.entry("Danaerys", 4));
        System.out.println(immutableMap);
    }

}
