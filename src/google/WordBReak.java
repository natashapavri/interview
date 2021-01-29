package google;

import java.util.HashSet;
import java.util.Set;

public class WordBReak {

	public static void main(String[] args) {
		String a = "catsandanddog";
		String[] b = { "cats", "and", "dog" };

		if (a.equals("") || a == null || b == null || b.length == 0)
			throw new IllegalArgumentException();

		Set<String> dict = new HashSet<>();
		for (String w : b) {
			dict.add(w);
		}

		boolean[] dp = new boolean[a.length() + 1];
		dp[0] = true;

		//total string is 0-j-i, we check if j-i is in dict & string 0-j is true
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dict.contains(a.substring(j, i)) && dp[j]) {
					dp[i] = true;
					break;
				}
			}
		}

		System.out.println(dp[a.length()]);

	}

}
