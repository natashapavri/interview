package google;

public class CakeOrPizzaCut {

	public static void main(String[] args) {
		String[] pizza = { "A..", "AAA", "..." };
		int k = 3;

		int rowS = 0;
		int colS = 0;
		int rowE = pizza.length - 1;
		int colE = pizza[0].length() - 1;
		int tmp = (int) 1e9 + 7;
		int[][][] dp = new int[rowE + 1][colE + 1][k + 1];

		int result = findWaysToCut(pizza, rowS, rowE, colS, colE, k, dp);
		System.out.println(result % tmp);
	}

	private static int findWaysToCut(String[] pizza, int rowS, int rowE, int colS, int colE, int k, int[][][] dp) {
		if (rowS > rowE || colS > colE || k < 0)
			return 0;

		if (dp[rowS][colS][k] != 0) {
			return dp[rowS][colS][k];
		}

		int result = 0;

		if (k == 1) {
			if (isPossible(pizza, rowS, rowE, colS, colE)) {
				result = 1;
			} else {
				result = 0;
			}
		} else {
			for (int i = rowS; i <= rowE; i++) {
				if (isPossible(pizza, rowS, i, colS, colE)) {
					result += findWaysToCut(pizza, i + 1, rowE, colS, colE, k - 1, dp);
				}
			}

			for (int i = colS; i <= colE; i++) {
				if (isPossible(pizza, rowS, rowE, colS, i)) {
					result += findWaysToCut(pizza, rowS, rowE, i + 1, colE, k - 1, dp);
				}
			}
		}
		dp[rowS][colS][k] = result;
		return result;
	}

	private static boolean isPossible(String[] pizza, int rowS, int rowE, int colS, int colE) {
		for (int i = rowS; i <= rowE; i++) {
			for (int j = colS; j <= colE; j++) {
				if (pizza[i].charAt(j) == 'A')
					return true;
			}
		}

		return false;
	}
}
