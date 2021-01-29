package google;

public class DistinctSubsequences {

	public static void main(String[] args) {
		String a = "rabbbiot";
		String b = "rabbit";

		int[][] dp = new int[a.length() + 1][b.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[a.length()][b.length()]);
	}
}
