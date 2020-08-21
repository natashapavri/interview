package trees;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	String prefix;
	Map<Character, TrieNode> children;
	private boolean isWord;

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

	public TrieNode(String prefix) {
		super();
		this.prefix = prefix;
		this.children = new HashMap<Character, TrieNode>();
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "TrieNode [prefix=" + prefix + "]";
	}

}
