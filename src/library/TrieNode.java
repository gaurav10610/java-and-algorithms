package library;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	private char c;
	private Map<Character, TrieNode> children;
	private boolean isEnd;

	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
}
