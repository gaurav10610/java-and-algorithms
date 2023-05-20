package strings;

import java.util.Arrays;
import java.util.List;
import library.Trie;

/**
 * Search a string or prefix in a prefix tree or trie
 * 
 *
 */
public class TrieSearching {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("Gaurav", "Gau", "Paras", "Godzilla", "Zebra");
    Trie trie = new Trie();

    list.forEach((string) -> {
      trie.insertString(string);
    });
    
    System.out.println(trie.searchPrefix("Gaur"));
    System.out.println(trie.searchString("Gaurav"));
    System.out.println(trie.searchString("RehneDe"));
  }

}
