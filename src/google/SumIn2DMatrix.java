package google;

public class SumIn2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { -8, 5, 7 }, { 3, 7, -8 }, { 5, -8, 9 } };
		int targetSum = 0;

		Integer[][] cache = new Integer[matrix.length][matrix[0].length];

		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int sumCalculated = findSumSquare(matrix, i, j, cache, targetSum);
				if(sumCalculated == targetSum)
					count++;
			}
		}

		System.out.println(count);
	}

	private static int findSumSquare(int[][] matrix, int i, int j, Integer[][] cache, int sum) {
		if (i == matrix.length || j == matrix[0].length) {
			return 0;
		}
		if (cache[i][j] != null)
			sum += cache[i][j];

		sum += matrix[i][j];
		cache[i][j] = sum;
		
		sum+=findSumSquare(matrix, i, j+1, cache, sum);
		sum+=findSumSquare(matrix, i+1, j, cache, sum);
		sum+=findSumSquare(matrix, i+1, j+1, cache, sum);
		
		return sum;
	}
}
