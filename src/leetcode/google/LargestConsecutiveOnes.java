package leetcode.google;

public class LargestConsecutiveOnes {

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 1 } };
		//dp[i][j][0] = horizontal
		//dp[i][j][1] = vertical
		//dp[i][j][2] = diagonal
		//dp[i][j][3] = anti-diagonal
		int[][][] dp = new int[grid.length][grid[0].length][4];
		int maxLength = Integer.MIN_VALUE;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					if (i == 0 && j == 0) {
						dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = dp[i][j][3] = 1;
					}
					if (j > 0) {
						dp[i][j][0] = dp[i][j - 1][0] + 1;
					}
					if (i > 0) {
						dp[i][j][1] = dp[i - 1][j][1] + 1;
					}
					if (i > 0 && j > 0) {
						dp[i][j][2] = dp[i - 1][j - 1][2] + 1;
					}
					if (i > 0 && j + 1 < grid[0].length) {
						dp[i][j][3] = dp[i - 1][j + 1][3] + 1;
					}
					maxLength = Math.max(maxLength, dp[i][j][0]);
					maxLength = Math.max(maxLength, dp[i][j][1]);
					maxLength = Math.max(maxLength, dp[i][j][2]);
					maxLength = Math.max(maxLength, dp[i][j][3]);
				}
			}
		}
		System.out.println(maxLength);
	}

}
