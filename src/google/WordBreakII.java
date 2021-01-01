package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	public static void main(String[] args) {
		String input = "catsandanddog";
		String[] dict = { "cat", "cats", "and", "sand", "dog" };

		Set<String> dictionary = new HashSet<>();
		for(String word : dict) {
			dictionary.add(word);
		}
		List<StringBuilder> results = new ArrayList<>();
		findSentences(input, dictionary, results, new StringBuilder(), 0);
		
		for(StringBuilder sb : results) {
			System.out.println(sb.toString());
		}
	}

	private static void findSentences(String input, Set<String> dictionary, List<StringBuilder> results, StringBuilder sb, int start) {
		
		if(start >= input.length()) {
			results.add(new StringBuilder(sb.toString()));
		}
		
		for(int i = start; i < input.length(); i++) {
			String str = input.substring(start, i + 1);
			if(dictionary.contains(str)) {
				sb.append(str).append(" ");
				findSentences(input, dictionary, results, sb, i + 1);
				// delete str and the space
				sb = sb.delete(start, i + 2);
			}
			
		}
	}

}
