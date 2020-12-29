package google;

import java.util.HashSet;
import java.util.Set;

public class FindSubsequencesOfString {

	public static void main(String[] args) {
		String input = "abppplee";
		String[] dict = { "able", "ale", "apple", "bale", "kangaroo" };

		Set<String> subsequences = new HashSet<>();
		findSubsequences(subsequences, input, new StringBuilder(), 0);

		int maxLength = Integer.MIN_VALUE;
		String output = "";
		for (String word : dict) {
			if (subsequences.contains(word)) {
				if (maxLength < word.length()) {
					maxLength = word.length();
					output = word;
				}
			}
		}

		System.out.println(output);

	}

	private static void findSubsequences(Set<String> subsequences, String input, StringBuilder sb, int start) {
		subsequences.add(new String(sb.toString()));
		for (int k = start; k < input.length(); k++) {
			sb.append(input.charAt(k));
			findSubsequences(subsequences, input, sb, k + 1);
			sb = sb.deleteCharAt(sb.length() - 1);
		}

	}
}
