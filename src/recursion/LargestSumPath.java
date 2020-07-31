package recursion;

public class LargestSumPath {

	public static void main(String[] args) {
		int[][] matrix = { { 3, 7, 9, 2, 7 }, { 9, 8, 3, 5, 5 }, { 1, 7, 9, 8, 5 }, { 3, 8, 6, 4, 10 }, { 6, 3, 9, 7, 8 } };

		Integer[][] cache = new Integer[matrix.length][matrix[0].length];
		
		int max = findLargestPath(matrix, 0, 0, cache);
		
		System.out.println(max);
	}
	

	private static int findLargestPath(int[][] matrix, int i, int j, Integer[][] cache) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
			return Integer.MIN_VALUE;
		}
		if(cache[i][j] != null) {
			return cache[i][j];
		}
		
		if(i == matrix.length - 1 && j == matrix[0].length -1) {
			return matrix[i][j];
		}
		
		int max = 0;
		max+=matrix[i][j];
		
		int next = Math.max(findLargestPath(matrix, i+1, j, cache), findLargestPath(matrix,i,j+1, cache) );
		max+=next;
		cache[i][j]=new Integer(max);
		
		return max;
	}
}
