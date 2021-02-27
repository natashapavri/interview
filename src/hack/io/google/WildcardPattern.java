package hack.io.google;

import java.util.ArrayList;
import java.util.List;

public class WildcardPattern {

	public static void main(String[] args) {
		String pattern = "1??0";
		List<String> patterns = new ArrayList<>();
		findAllCombinations(pattern.toCharArray(), patterns, 0);
		for (String sb : patterns) {
			System.out.println(sb);
		}
	}

	private static void findAllCombinations(char[] pattern, List<String> patterns, int start) {
		if (start == pattern.length) {
			patterns.add(new String(pattern));
			return;
		}

		if (pattern[start] == '?') {
			for (int k = 0; k < 2; k++) {
				pattern[start] = (char) (k + '0');
				findAllCombinations(pattern, patterns, start + 1);
				pattern[start] = '?';
			}
		} else {
			findAllCombinations(pattern, patterns, start + 1);
		}

	}
}
