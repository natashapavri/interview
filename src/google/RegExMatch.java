package google;

public class RegExMatch {

	public static void main(String[] args) {
		String input = "aab";
		String pattern = "c*a*b";

		if (input.equals(pattern)) {
			System.out.println(true);
			return;
		}

		if (!pattern.contains(".") && !pattern.contains("*")) {
			if (!input.equals(pattern)) {
				System.out.println(false);
				return;
			}
		}

		boolean isMatch = isMatch(input.toCharArray(), pattern.toCharArray());

		System.out.println(isMatch);

		// time complexity = O(mxn)
		// Solution link : https://www.youtube.com/watch?v=l3hda49XcDE
	}

	private static boolean isMatch(char[] input, char[] pattern) {

		boolean[][] dp = new boolean[input.length + 1][pattern.length + 1];
		dp[0][0] = true;

		// initialize the first row with T/F
		for (int j = 1; j < dp[0].length; j++) {
			if (pattern[j - 1] == '*') {
				dp[0][j] = dp[0][j - 2];
			}
		}

		// initialize rest of the matrix
		/**
		 * dp[i][j] = if(text[i] == pattern[j] || pattern[j] == ".") then
		 * dp[i-1][j-1] if(pattern[j-1] == '*') 1. 0 occurrences of pattern =
		 * dp[i][j-2] 2. text[i]==pattern[j-1] || pattern[j-1] == '.' =
		 * dp[i-1][j]
		 */

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (input[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {
					dp[i][j] = dp[i][j - 2];
					if (input[i - 1] == pattern[j - 2] || pattern[j - 2] == '.') {
						dp[i][j] |= dp[i - 1][j];
					}
				} else {
					dp[i][j] = false;
				}
			}
		}

		return dp[input.length][pattern.length];

	}
}
