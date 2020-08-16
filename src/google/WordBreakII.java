package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {

	public static void main(String[] args) {
		String input = "catsanddog";
		String[] dict = { "cat", "cats", "and", "sand", "dog" };

		Map<Integer, List<Integer>> indexLength = new HashMap<>();

		for (String word : dict) {
			Integer index = input.indexOf(word);
			if(index == -1) continue;
			indexLength.putIfAbsent(index, new ArrayList<Integer>());
			indexLength.get(index).add(word.length());
		}
		
		if(indexLength.size() == 0) System.out.println("No match");
		
		Set<StringBuilder> sentences = new HashSet<>();
		findSentences(indexLength, input, sentences, new StringBuilder(), 0);
		
		for(StringBuilder sb : sentences) {
			System.out.println(sb.toString());
		}
	}

	private static void findSentences(Map<Integer, List<Integer>> indexLength, String input, Set<StringBuilder> sentences, StringBuilder sb, int nextIndex) {
		sentences.add(sb);
		if(indexLength.containsKey(nextIndex) && nextIndex < input.length()) {
			for(Integer length : indexLength.get(nextIndex)) {
				StringBuilder s = new StringBuilder(sb);
				s.append(" ");
				s.append(input.substring(nextIndex, nextIndex + length));
				sentences.add(s);
				findSentences(indexLength, input, sentences, s, nextIndex + length);
				sentences.remove(sb);
			}
		}
	}
}
