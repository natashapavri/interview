package leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {

	public static void main(String[] args) {
		String[] words = {"abcd","dcba","lls","s","sssll"};
		List<List<Integer>> result = new ArrayList<>();
		
		Map<String, Integer> dictionary = new HashMap<>();
		for(int i = 0; i < words.length; i++) {
			dictionary.put(words[i], i);
		}
		
		/**
		 * case 1 = We have the string and its reverse both in the dict
		 * case 2 = check suffixes of string which is a palindrome, check if the reverse of the suffix is in the dict
		 * case 3 = check prefixes of string which is a palindrome, check if the reverse of the prefix is in the dict 
		 */
		
		for(String word : dictionary.keySet()) {
			int wordIndex = dictionary.get(word);
			
			// case 1
			String reverse = new StringBuilder(word).reverse().toString();
			if(dictionary.containsKey(reverse) && dictionary.get(reverse) != wordIndex) {
				int reverseIndex = dictionary.get(reverse);
				List<Integer> l = new ArrayList<>();
				l.add(wordIndex);
				l.add(reverseIndex);
				result.add(l);
			}
			
			//case 2
			List<String> suffixes = getAllSuffixes(word);
			for(String suffix : suffixes) {
				String sReverse = new StringBuilder(suffix).reverse().toString();
				if(dictionary.containsKey(sReverse)) {
					int suffixIndex = dictionary.get(sReverse);
					List<Integer> l = new ArrayList<>();
					l.add(wordIndex);
					l.add(suffixIndex);
					result.add(l);
				}
			}
			
			//case 3
			List<String> prefixes = getAllPrefixes(word);
			for(String prefix : prefixes) {
				String pReverse = new StringBuilder(prefix).reverse().toString();
				if(dictionary.containsKey(pReverse)) {
					int prefixIndex = dictionary.get(pReverse);
					List<Integer> l = new ArrayList<>();
					l.add(prefixIndex);
					l.add(wordIndex);
					result.add(l);
				}
			}
		}
		
		for(List<Integer> l : result) {
			System.out.print("[" + l.get(0) + ", " + l.get(1) + "]");
			System.out.println();
		}
	}

	// total string = 0 - i - length. we need 0 - i(not including i) hence we will check if i - length is a palindrome.
	private static List<String> getAllPrefixes(String word) {
		List<String> prefixes = new ArrayList<>();
		for(int i = 0; i < word.length(); i++) {
			if(isPalindrome(word.substring(i, word.length()))) {
				String prefix = word.substring(0, i);
				prefixes.add(prefix);
			}
		}
		return prefixes;
	}

	// total string = 0 - i - length. we need i - length (not including i) hence we will check if 0 - i is a palindrome. 
	private static List<String> getAllSuffixes(String word) {
		List<String> suffixes = new ArrayList<>();
		for(int i = 0; i < word.length(); i++) {
			if(isPalindrome(word.substring(0, i + 1))) {
				String suffix = word.substring(i + 1, word.length());
				suffixes.add(suffix);
			}
		}
		return suffixes;
	}
	
	private static boolean isPalindrome(String word) {
		int start = 0;
		int end = word.length() - 1;
		while(start < end) {
			if(word.charAt(start) != word.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
}
