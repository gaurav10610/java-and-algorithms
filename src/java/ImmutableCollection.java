package java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableCollection {

  public static void main(String[] args) {
    List<Name> list = new ArrayList<Name>();
    list.add(new Name("Gaurav"));
    list.add(new Name("Paras"));
    list.add(new Name("Suman"));
    list.add(new Name("Prabhat"));
    list.add(new Name("Shobhit"));

    System.out.println("Before modifications:");
    list.forEach(element -> System.out.print(" " + element.name));
    System.out.println("\n");

    // Immutable list
    List<Name> immutableList = Collections.unmodifiableList(list);
    immutableList.add(new Name("Himanshu"));

    System.out.println("After modifications:");
    immutableList.forEach(element -> System.out.print(" " + element.name));
  }

  // public static <T> void makeImmutable(List<T> list){
  // }

}


class Name {
  String name;

  Name(String name) {
    this.name = name;
  }
}
