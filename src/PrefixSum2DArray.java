
public class PrefixSum2DArray {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] result = prefixSum(matrix);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + ", ");
			}
			System.out.println();
		}
		int sum = query(2, 1, 2, 1, result);
		System.out.println(sum);
		update(2, 1, 9, matrix, result);
		System.out.println(result[2][1]);
	}

	private static void update(int x, int y, int value, int[][] matrix, int[][] result) {
		int diff = Math.abs(matrix[x][y] - value);
		for (int i = x; i < result.length; i++) {
			for (int j = y; j < result[0].length; j++) {
				result[i][j] += diff;
			}
		}
	}

	private static int query(int r1, int c1, int r2, int c2, int[][] result) {
		return result[r2][c2] - result[r1 - 1][c1] - result[r1][c1 - 1] + result[r1 - 1][c1 - 1];
	}

	private static int[][] prefixSum(int[][] matrix) {
		int[][] result = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 && j == 0) {
					result[i][j] = matrix[i][j];
				}
				if (i == 0 && j > 0) {
					result[i][j] = result[i][j - 1] + matrix[i][j];
				}
				if (i > 0 && j == 0) {
					result[i][j] = result[i - 1][j] + matrix[i][j];
				}
				if (i > 0 && j > 0) {
					result[i][j] = result[i - 1][j] + result[i][j - 1] + matrix[i][j] - result[i - 1][j - 1];
				}
			}
		}
		return result;
	}
}
