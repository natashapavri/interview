package google;

public class LongestPathInMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 2, 2, 3, 4 }, { 3, 2, 3, 4 }, { 4, 5, 6, 7 } };
		int[][] matrix2 = { { 1, 2 }, { 3, 4 } };

		Integer[][] cache = new Integer[matrix.length][matrix[0].length];
		Integer[][] cache2 = new Integer[matrix2.length][matrix2[0].length];

		int maxLength = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				maxLength = Math.max(maxLength, findSquare(matrix, i, j, cache));
			}
		}

		System.out.println(maxLength);

		maxLength = 0;
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[0].length; j++) {
				maxLength = Math.max(maxLength, findSquare(matrix2, i, j, cache2));
			}
		}

		System.out.println(maxLength);

	}

	private static int findSquare(int[][] matrix, int i, int j, Integer[][] cache) {
		if (i == matrix.length - 1 && j == matrix[0].length - 1)
			return 1;

		if (cache[i][j] != null) {
			return cache[i][j];
		}

		int countDown = Integer.MIN_VALUE;
		int countRight = Integer.MIN_VALUE;

		if (i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j]) {
			countDown = findSquare(matrix, i + 1, j, cache);
		} else if (j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1]) {
			countRight = findSquare(matrix, i, j + 1, cache);
		}
		int count = 1 + Math.max(countDown, countRight);
		cache[i][j] = count;

		return cache[i][j];
	}
}
