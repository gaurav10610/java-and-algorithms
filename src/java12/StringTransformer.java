package java12;

import java.util.List;

public class StringTransformer {

  public static void main(String[] args) {

    List<String> list = List.of("    Gaurav Kumar Yadav     ", "   Shikha Yadav");

    list.stream()
        .map(string -> string.transform(String::strip).transform(value -> value.replace(" ", "-")))
        .forEach(string -> System.out.println(string));
  }

}
