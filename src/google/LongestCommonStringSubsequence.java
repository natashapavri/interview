package google;

public class LongestCommonStringSubsequence {

	// Solution link : https://www.youtube.com/watch?v=0Ql40Llp09E
	// Subsequence = characters in order but not together	
	public static void main(String[] args) {
		String s = "abcd";
		String t = "aebd";
		
		int lcs = lcs(s, t);
		
		System.out.println(lcs);
	}

	/**
	 * lcs (s1, s2) = 1 + lcs(r1,r2) if c1 == c2
	 * 				= Max(lcs(r1,s2), lcs(s1,r2) if c1 <> c2
	 * lcs (s1, s2) = lcs(c1r1, c2r2)
	 * 				= [	s(r1) x s(r2) or 
	 * 					s(r1) x c2s(r2) or 
	 * 					c1s(r1) x s(r2) or
	 * 					c1s(r1) x c2s(r2) ]
	 */
	private static int lcs(String s, String t) {
		
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		for(int i = dp.length - 2; i>=0; i--) {
			for(int j = dp[0].length - 2; j>=0; j--) {
				char sc = s.charAt(i);
				char tc = t.charAt(j);
				if(sc == tc) {
					// diagonally downwards
					dp[i][j] = 1 + dp[i+1][j+1];
				} else {
					// max of both sides - right and down
					dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
				}
			}
		}
		
		return dp[0][0];
	}
}
