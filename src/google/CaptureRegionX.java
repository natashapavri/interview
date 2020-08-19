package google;

public class CaptureRegionX {

	//https://www.youtube.com/watch?v=0ZJViJEdtEc
	
	public static void main(String[] args) {
		char[][] matrix = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };

		int rows = matrix.length;
		int cols = matrix[0].length;

		for (int r = 0; r < matrix.length; r++) {
			if (matrix[r][0] == 'O')
				dfs(matrix, r, 0);
			if (matrix[r][cols - 1] == 'O')
				dfs(matrix, r, cols - 1);
		}

		for (int c = 0; c < matrix[0].length; c++) {
			if (matrix[0][c] == 'O')
				dfs(matrix, 0, c);
			if (matrix[rows - 1][c] == 'O')
				dfs(matrix, rows - 1, c);
		}

		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				if (matrix[r][c] == '*')
					matrix[r][c] = 'O';
				else if (matrix[r][c] == 'O')
					matrix[r][c] = 'X';
			}
		}

		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				System.out.print(matrix[r][c] + ", ");
			}
			System.out.println();
		}
	}

	private static void dfs(char[][] matrix, int r, int c) {
		if (r >= matrix.length || c >= matrix[0].length || r < 0 || c < 0 || matrix[r][c] != 'O') {
			return;
		}

		matrix[r][c] = '*';

		dfs(matrix, r, c - 1);
		dfs(matrix, r, c + 1);
		dfs(matrix, r + 1, c);
		dfs(matrix, r - 1, c);
	}
}
