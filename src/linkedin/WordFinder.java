package linkedin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import trees.TrieNode;

public class WordFinder {

	/*
	 * Given an array of characters, returns a Set of all of the words in the
	 * word list that can be made with any subset of those characters.
	 * Duplicates may be present in the array, but each array index may only be
	 * used once per word. Thus, given {'o', 'r', 's', 'd', 'o', 'w', 'e'} you
	 * might return (among others) "word", "words", and "wood", but not "order".
	 * The list is expected to be short (less than 100 characters)
	 */

	public static void main(String[] args) {
		String[] dict = { "pot", "pothole", "hole", "top", "pots", "spot", "hot" };
		String input = "ehloopts";
		List<Character> chars = new ArrayList<>();
		for (char c : input.toCharArray()) {
			chars.add(c);
		}

		TrieNode root = prepareDictionary(dict);
		Set<String> results = new HashSet<>();
		findAllWords(root, chars, results);
		for (String s : results) {
			System.out.println(s);
		}
	}

	private static void findAllWords(TrieNode current, List<Character> input, Set<String> results) {
		if (current.isWord()) {
			results.add(current.getPrefix());
		}
		for (Character c : input) {
			if (!current.getChildren().containsKey(c)) {
				continue;
			}
			// characters at an index can be used only in one word
			List<Character> newChars = new ArrayList<>(input);
			newChars.remove(c);
			findAllWords(current.getChildren().get(c), newChars, results);
		}
	}

	private static TrieNode prepareDictionary(String[] dict) {
		TrieNode root = new TrieNode("");
		for (String word : dict) {
			prepareDictionary(word, root);
		}
		return root;
	}

	private static void prepareDictionary(String word, TrieNode root) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			if (!current.getChildren().containsKey(word.charAt(i))) {
				TrieNode node = new TrieNode(word.substring(0, i + 1));
				current.getChildren().put(word.charAt(i), node);
			}
			current = current.getChildren().get(word.charAt(i));
			if (i == word.length() - 1) {
				current.setWord(true);
			}
		}
	}

}
