package google;

public class LargestRectangle {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 0, 1, 1 }, { 1, 0, 0 } };
		int[][] cache = new int[matrix.length][matrix[0].length];

		int maxLength = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 1)
					maxLength = Math.max(maxLength, findSquare(matrix, cache, i, j));
			}
		}
		
		System.out.println(maxLength * maxLength);
	}

	private static int findSquare(int[][] matrix, int[][] cache, int i, int j) {
		if(i == matrix.length || j == matrix[0].length) return 0;
		if(matrix[i][j] == 0) return 0;
		if(cache[i][j] > 0) return cache[i][j];
		cache[i][j] = 1 + Math.min(findSquare(matrix, cache, i+1, j), findSquare(matrix, cache, i+1, j+1));
		
		return cache[i][j];
	}

}
