package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import trees.TrieNode;

public class HotSentences {

	public static void main(String[] args) {
		String[] sentences = {"i love you", "island","ironman", "i love leetcode"};
		int[] times = {5,3,2,2};
		
		TrieNode root = new TrieNode("-1");
		root = prepareTrie(sentences, root);
		List<String> output = input("i l", root);
		
		if(output.size() == 0) System.out.println("Nothing to return");
		
		Map<Integer, String> weighted = new TreeMap<>();
		
		for(int i = 0;i<sentences.length;i++) {
			if(output.contains(sentences[i])) {
				if(weighted.containsKey(times[i])) {
					String sent = weighted.get(times[i]);
					if(sentences[i].compareTo(sent) < 0) {
						weighted.replace(times[i], sentences[i]);
					}
				} else {
					weighted.put(times[i], sentences[i]);
				}
			} 
		}
		
		for(String str : weighted.values()) {
			System.out.println(str);
		}
	}

	private static List<String> input(String string, TrieNode root) {
		List<String> result = new ArrayList<>();
		if(string.equals("#")) return result;
		findSentences(string, root, result);
		return result;
	}

	private static TrieNode prepareTrie(String[] sentences, TrieNode root) {
		for(String sentence : sentences) {
			prepareTrie(sentence, root);
		}
		
		return root;
	}
	
	private static void findSentences(String string, TrieNode root, List<String> result) {
        TrieNode current = root;
        for(int i = 0; i< string.length(); i++) {
        	if(current.getChildren().containsKey(string.charAt(i))) {
            	findSentences(current, result);
            }
        }
    }

	private static void findSentences(TrieNode current, List<String> result) {
		if(current.isWord()) {
			result.add(current.getPrefix());
		} 
		for(Character c : current.getChildren().keySet()) {
			findSentences(current.getChildren().get(c), result);
		}
	}

	private static void prepareTrie(String sentence, TrieNode root) {
		TrieNode current = root;
		for(int i = 0;i<sentence.length();i++) {
			if(!current.getChildren().containsKey(sentence.charAt(i))) {
				TrieNode t = new TrieNode(sentence.substring(0,  i+1));
				current.getChildren().put(sentence.charAt(i), t);
			}
			current = current.getChildren().get(sentence.charAt(i));
			if(i == sentence.length()-1) {
				current.setWord(true);
			}
		}
	}
}
