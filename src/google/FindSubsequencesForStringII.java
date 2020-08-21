package google;

import java.util.HashMap;
import java.util.Map;

public class FindSubsequencesForStringII {

	public static void main(String[] args) {
		String input = "abppplee";
		String[] dict = { "able", "ale", "apple", "bale", "kangaroo" };
		Map<String, Integer> wordFreq = new HashMap<String, Integer>();

		for(String word : dict) {
			wordFreq.put(word, 0);
		}
		
		String longestString = findLongestString(wordFreq, input);
		System.out.println(longestString);
	}

	private static String findLongestString(Map<String, Integer> wordFreq, String input) {
		String longestString = "";
		for(char c : input.toCharArray()) {
			
		}
		return longestString;
	}

	
	
}
