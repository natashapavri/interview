package google;

import java.util.HashMap;
import java.util.Map;

public class SubMatrixOfSum {

	public static void main(String[] args) {
		int[][] matrix = { { -8, 5, 7 }, { 3, 7, -8 }, { 5, -8, 9 } };

		int targetSum = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
			}
		}

		Map<Integer, Integer> prefixSum = new HashMap<Integer, Integer>();
		int count = 0;
		for (int c1 = 0; c1 < matrix[0].length; c1++) {
			for (int c2 = c1; c2 < matrix[0].length; c2++) {
				prefixSum.clear();
				prefixSum.put(0, 1);
				int curSum = 0;
				for (int r = 0; r < matrix.length; r++) {
					curSum += (c1 == 0) ? matrix[r][c2] : matrix[r][c2] - matrix[r][c1 - 1];
					count += prefixSum.getOrDefault(curSum - targetSum, 0);
					prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) + 1);
				}
			}
		}

		System.out.println(count);
	}
}
