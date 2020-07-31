package google;

public class TwoDRotation {

	/**
	 * 90 rotation anti-clock = transpose & reverse columns
	 * 90 rotation clock = transpose & reverse rows
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4, 17 }, { 5, 6, 7, 8, 18 }, { 9, 10, 11, 12, 19 }, { 13, 14, 15, 16, 20 },
				{ 21, 22, 23, 24, 25 } };

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println();
		
		transpose(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		anticlock(matrix);
		clock(matrix);

	}

	private static void clock(int[][] matrix) {
		
		reverseRows(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
		
		System.out.println();
	}

	private static void reverseRows(int[][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length/2;j++) {
				int newIndex = matrix[0].length-j-1;
				int t = matrix[i][j];
				matrix[i][j] = matrix[i][newIndex];
				matrix[i][newIndex] = t;
			}
		}
	}

	private static void anticlock(int[][] matrix) {

		reverseColumns(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
		
		System.out.println();
	}

	private static void reverseColumns(int[][] matrix) {
		for (int j = 0; j < matrix[0].length; j++) {
			for (int i = 0; i < matrix.length / 2; i++) {
				int newIndex = matrix[0].length - 1 - i;
				int t = matrix[i][j];
				matrix[i][j] = matrix[newIndex][j];
				matrix[newIndex][j] = t;
			}
		}
	}

	private static void transpose(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
