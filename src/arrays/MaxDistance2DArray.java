package arrays;

public class MaxDistance2DArray {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5 }, { 1, 2, 3 } };

		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (maxVal < matrix[i][j]) {
					maxVal = matrix[i][j];
				}
				if (minVal > matrix[i][j]) {
					minVal = matrix[i][j];
				}
			}
		}

		System.out.println(Math.abs(maxVal - minVal));
	}
}
