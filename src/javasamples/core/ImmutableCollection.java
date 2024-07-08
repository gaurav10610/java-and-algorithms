package javasamples.core;

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

    System.out.printf("Before modifications: %s", list);
    System.out.println();

    // Immutable list
    List<Name> immutableList = Collections.unmodifiableList(list);
    immutableList.add(new Name("Himanshu"));

    System.out.printf("After modifications: %s", immutableList);
  }

}


class Name {
  String name;

  Name(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Name{" +
            "name='" + name + '\'' +
            '}';
  }
}
