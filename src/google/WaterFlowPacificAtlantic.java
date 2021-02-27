package google;

import java.util.ArrayList;
import java.util.List;

public class WaterFlowPacificAtlantic {

	//https://github.com/shileiwill/destination/blob/master/Round1/src/company/google/PacificAtlanticWaterFlow.java
	//DFS template - https://www.youtube.com/watch?v=LVlihRYfVVw
	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		boolean[][] avisited = new boolean[matrix.length][matrix[0].length];
		boolean[][] pvisited = new boolean[matrix.length][matrix[0].length];

		int firstRow = 0;
		int firstCol = 0;
		int lastRow = matrix.length - 1;
		int lastCol = matrix[0].length - 1;

		// first column and last column
		for (int i = 0; i < matrix.length; i++) {
			dfs(matrix, i, firstCol, pvisited, directions);
			dfs(matrix, i, lastCol, avisited, directions);
		}

		// first row and last row
		for (int j = 0; j < matrix[0].length; j++) {
			dfs(matrix, firstRow, j, pvisited, directions);
			dfs(matrix, lastRow, j, avisited, directions);
		}

		List<int[]> results = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (avisited[i][j] && pvisited[i][j]) {
					int[] result = { i, j };
					results.add(result);
				}
			}
		}

		for (int[] result : results) {
			System.out.print(result[0] + ", " + result[1]);
			System.out.println();
		}
	}

	private static void dfs(int[][] matrix, int i, int j, boolean[][] visited, int[][] directions) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
			return;
		}
		visited[i][j] = true;

		for (int[] dir : directions) {
			int newX = i + dir[0];
			int newY = j + dir[1];

			if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && !visited[newX][newY]
					&& matrix[newX][newY] >= matrix[i][j]) {
				dfs(matrix, newX, newY, visited, directions);
			}
		}
	}
}
