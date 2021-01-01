package google;

public class LongestRepeatedSubsequence {

	// difference between longest common subsequence and longest repeated subsequence = characters must be same but not indices
	public static void main(String[] args) {
		String str = "abacbc";
		
		int length = lrs(str);
		
		System.out.println(length);
	}

	// same as longest common subsequence except that characters at the same index are not same
	private static int lrs(String str) {
		int[][] dp = new int[str.length() + 1][str.length() + 1];
		
		for(int i = dp.length - 2; i>=0; i--) {
			for(int j = dp[0].length - 2; j>=0; j--) {
				//diagonally downwards 
				if(str.charAt(i) == str.charAt(j) && i != j) {
					dp[i][j] = 1 + dp[i+1][j+1];
				} else {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		
		return dp[0][0];
	}
}
