package google;

public class InterleavingString {

	public static void main(String[] args) {
		String A = "aabcc";
		String B = "dbbca";
		String C = "aadbbbaccc";

		boolean isMatch = isInterleaving(A, B, C);
		System.out.println(isMatch);
		isMatch = interleavingOptimized(A.toCharArray(), B.toCharArray(), C.toCharArray());
		System.out.println(isMatch);

	}

	private static boolean isInterleaving(String a, String b, String c) {

		int i = 0, j = 0, k = 0;

		while (i < a.length() || j < b.length() || k < c.length()) {

			while (i < a.length() && k < c.length() && a.charAt(i) == c.charAt(k)) {
				i++;
				k++;
			}
			while (j < b.length() && k < c.length() && b.charAt(j) == c.charAt(k)) {
				j++;
				k++;
			}
			if(a.charAt(i) != c.charAt(k) && b.charAt(j) != c.charAt(k)) {
				break;
			}
		}

		if (i == a.length() && j == b.length() && k == c.length()) {
			return true;
		}

		return false;
	}

	// time complexity = O(mxn)
	// space complexity = O(mxn)
	// Solution link = https://www.youtube.com/watch?v=ih2OZ9-M3OM
	private static boolean interleavingOptimized(char[] a, char[] b, char[] c) {
		boolean[][] dp = new boolean[a.length + 1][b.length + 1];
		dp[0][0] = true;

		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				int k = i + j;
				if (c[k - 1] == a[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else if (c[k - 1] == b[j - 1]) {
					dp[i][j] = dp[i][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}
		
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[a.length][b.length];
	}
}
