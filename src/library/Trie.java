package library;

import java.util.Map;

public class Trie {

  private TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  public TrieNode getRoot() {
    return root;
  }

  public void setRoot(TrieNode root) {
    this.root = root;
  }

  public void insertString(String string) {

    Map<Character, TrieNode> children = this.getRoot().getChildren();

    for (int i = 0; i < string.length(); i++) {
      char c = string.charAt(i);
      TrieNode newNode;

      // If trie does not contains the children
      if (!children.containsKey(c)) {
        newNode = new TrieNode();
        newNode.setC(c);
        children.put(c, newNode);
      }

      // Set isEnd when node contains a string's ending
      if (i == string.length() - 1) {
        children.get(c).setEnd(true);
      }
      children = children.get(c).getChildren();
    }
  }

  /**
   * Search whole string
   * 
   * @param string
   * @return
   */
  public boolean searchString(String string) {
    TrieNode node = searchNode(string);
    return (node != null && node.isEnd()) ? true : false;
  }

  /**
   * Search prefix
   * 
   * @param prefix
   * @return
   */
  public boolean searchPrefix(String prefix) {
    TrieNode node = searchNode(prefix);
    return node != null ? true : false;
  }

  private TrieNode searchNode(String string) {
    Map<Character, TrieNode> children = this.getRoot().getChildren();
    int i = 0;
    TrieNode node = null;

    while (i < string.length()) {
      char c = string.charAt(i);
      if (!children.containsKey(c)) {
        return null;
      }
      if (i == string.length() - 1) {
        node = children.get(c);
      }
      children = children.get(c).getChildren();
      i++;
    }
    return node;
  }
}
