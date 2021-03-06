package arrays;

public class MagicMatrix {

	/**
	 * 1. The position of next number is calculated by decrementing row number
	 * of previous number by 1, and incrementing the column number of previous
	 * number by 1. At any time, if the calculated row position becomes -1, it
	 * will wrap around to n-1. Similarly, if the calculated column position
	 * becomes n, it will wrap around to 0.
	 * 
	 * 2. If the magic square already contains a number at the calculated
	 * position, calculated column position will be decremented by 2, and
	 * calculated row position will be incremented by 1.
	 * 
	 * 3. If the calculated row position is -1 & calculated column position is
	 * n, the new position would be: (0, n-2).
	 */
	public static void main(String[] args) {
		int n = 3;

		// for testing
		int magic_matrix = n * ((n * n) + 1) / 2;

		int[][] matrix = new int[n][n];

		int nextRow = n / 2;
		int nextColumn = n - 1;

		// 3x3 matrix needs 1-9 numbers
		// 5x5 will need 1-25 numbers
		for (int i = 1; i <= n*n; i++) {

			if (nextRow < 0 && nextColumn >= n) // 3rd condition
			{
				nextColumn = n - 2;
				nextRow = 0;
			} else {
				// 1st condition helper if next number
				// goes to out of square's right side
				if (nextColumn >= n)
					nextColumn = 0;

				// 1st condition helper if next number is
				// goes to out of square's upper side
				if (nextRow < 0)
					nextRow = n - 1;
			}

			// 2nd condition
			if (matrix[nextRow][nextColumn] != 0) {
				nextColumn -= 2;
				nextRow++;
			}

			matrix[nextRow][nextColumn] = i;

			// 1st condition
			nextColumn++;
			nextRow--;

		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}

		boolean isMagic = checkMatrix(matrix, n);
		
		System.out.println(isMagic);
	}

	private static boolean checkMatrix(int[][] matrix, int n) {
		int magicMatrix = n * ((n * n) + 1) / 2;

		// check sum of all rows
		for (int i = 0; i < matrix.length; i++) {
			int sum = 0;
			for (int j = 0; j < matrix[0].length; j++) {
				sum += matrix[i][j];
			}
			if (sum != magicMatrix) {
				return false;
			}
		}

		// check sum of all columns
		for (int i = 0; i < matrix[0].length; i++) {
			int sum = 0;
			for (int j = 0; j < matrix.length; j++) {
				sum += matrix[j][i];
			}
			if (sum != magicMatrix) {
				return false;
			}
		}

		// check sum of left to right diagonal
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum += matrix[i][i];
		}
		if (sum != magicMatrix) {
			return false;
		}

		// check sum of right to left diagonal
		sum = 0;
		for (int i = matrix[0].length-1; i >=0; i--) {
			sum += matrix[i][i];
		}
		if (sum != magicMatrix) {
			return false;
		}
		
		return true;
	}
}
