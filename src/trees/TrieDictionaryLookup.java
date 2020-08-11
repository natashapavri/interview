package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieDictionaryLookup {

	public static void main(String[] args) {

		// find a word with prefix in dict
		String[] dict = { "abc", "acd", "bcd", "def", "a", "aba" };
		TrieNode root = prepareDictionary(dict);
		String prefix = "d";
		List<String> results = findAllWithPrefix(root, prefix);
		for (String str : results) {
			System.out.println(str);
		}

		// how many chars to delete to make a word in dict
		String[] dict2 = { "a", "aa", "aaa" };
		String word = "abbs";
		TrieNode root2 = prepareDictionary(dict2);
		int deleteChars = findMinimumDeletes(word, root2);
		System.out.println(deleteChars);

		// find all substrings in string
		String text = "ababa";
		List<String> texts = new ArrayList<>();
		for (int i = 0; i < text.length(); i++) {
			String str = text.substring(i, text.length());
			texts.add(str);
		}
		String[] t = new String[texts.size()];
		int i = 0;
		for (String s : texts) {
			t[i++] = s;
		}
		TrieNode root3 = prepareDictionary(t);
		List<String> substrings = new ArrayList<>();
		findSubstrings(root3, substrings);
		for (String str : substrings) {
			System.out.println(str);
		}

		// find shortest prefix for all words
		String[] words = { "zebra", "dog", "duck", "dove" };
		TrieNode root4 = prepareDictionary(words);
		Map<String, String> prefixMap = findShortestPrefix(root4, words);
		for(String w : prefixMap.keySet()) {
			System.out.println(w + " : " + prefixMap.get(w));
		}

	}

	private static Map<String, String> findShortestPrefix(TrieNode root4, String[] words) {
		Map<String, String> prefixMap = new HashMap<>();
		TrieNode current = root4;
		for(String word : words) {
			for(char c : word.toCharArray()) {
				if(current.getChildren().containsKey(c)) {
					if(current.getChildren().size() <= 1) {
						break;
					}
					current = current.getChildren().get(c);
				}
			}
			prefixMap.put(word, current.getPrefix());
			current = root4;
		}
		return prefixMap;
	}

	private static void findSubstrings(TrieNode root3, List<String> results) {
		TrieNode current = root3;
		if (current.isWord())
			results.add(current.getPrefix());
		for (Character c : current.getChildren().keySet()) {
			findSubstrings(current.getChildren().get(c), results);
		}
	}

	private static int findMinimumDeletes(String word, TrieNode top) {
		int deletes = 0;
		if (top == null)
			return 0;
		TrieNode current = top;
		for (Character c : word.toCharArray()) {
			if (current.getChildren().containsKey(c)) {
				current = current.getChildren().get(c);
			} else {
				deletes += 1;
			}
		}

		return deletes;
	}

	private static List<String> findAllWithPrefix(TrieNode root, String prefix) {
		List<String> results = new ArrayList<String>();
		if (root == null)
			return null;
		TrieNode current = root;
		for (Character c : prefix.toCharArray()) {
			if (current.getChildren().containsKey(c)) {
				current = current.getChildren().get(c);
			} else {
				return results;
			}
		}
		findAllWords(current, results);
		return results;
	}

	private static void findAllWords(TrieNode current, List<String> results) {
		if (current.isWord()) {
			results.add(current.getPrefix());
		}
		for (Character c : current.getChildren().keySet()) {
			findAllWords(current.getChildren().get(c), results);
		}
	}

	private static TrieNode prepareDictionary(String[] dict) {
		TrieNode root = new TrieNode("");
		for (String str : dict) {
			prepareNode(root, str);
		}
		return root;
	}

	private static void prepareNode(TrieNode root, String str) {
		TrieNode current = root;
		for (int i = 0; i < str.length(); i++) {
			if (!current.getChildren().containsKey(str.charAt(i))) {
				current.getChildren().put(str.charAt(i), new TrieNode(str.substring(0, i + 1)));
			}
			current = current.getChildren().get(str.charAt(i));
			if (i == str.length() - 1) {
				current.setWord(true);
			}
		}
	}
}

class TrieNode {
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
