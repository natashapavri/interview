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
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {
				prefixSum.clear();
				prefixSum.put(0, 1);
				int curSum = 0;
				for (int k = 0; k < matrix[0].length; k++) {
					curSum = curSum + matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
					count += prefixSum.getOrDefault(curSum - targetSum, 0);
					prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) + 1);
				}
			}
		}

		System.out.println(count);
	}
}
