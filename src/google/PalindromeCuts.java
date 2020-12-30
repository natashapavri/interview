package google;

public class PalindromeCuts {

	public static void main(String[] args) {
		String str = "abccbc";

		// Solution Link:-https://youtu.be/qmTtAbOTqcg
		// time complexity = o(n^2)

		// grid to decide if partitions are palindromes
		boolean[][] dp = new boolean[str.length()][str.length()];

		// g = gap between indices
		// i = start of string
		// j = end of string
		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp.length; j++, i++) {
				if (g == 0) {
					dp[i][j] = true;
				} else if (g == 1) {
					// both start and end chars must be the same
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				} else {
					// start and end chars must be same && middle must be a
					// palindrome
					if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				}
			}
		}

		int[] storage = new int[str.length()];
		storage[0] = 0;
		// full string = 0-j
		// 0-i-j is the full string so 0-i will be the remaining
		for (int j = 1; j < storage.length; j++) {
			if (dp[0][j] == true) {
				storage[j] = 0;
			}
			int min = Integer.MAX_VALUE;
			for (int i = j; i >= 1; i--) {
				if (dp[i][j] == true) {
					int value = storage[i - 1];
					min = Math.min(min, value);
				}
			}
			// + 1 is because we made a cut with the dp[i][j]
			storage[j] = min + 1;
		}

		System.out.println(storage[storage.length - 1]);
	}
}
