package leetcode.google;

import java.util.TreeSet;

public class MaximumSum2DNotLargerThan {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 0, 1 }, { 0, -2, 3 } };
		int limit = 2;
		for(int i = 1; i < matrix.length; i++) {
			for(int j = 1; j < matrix[0].length; j++) {
				matrix[i][j] = matrix[i][j] + matrix[i][j-1];
			}
		}
		
		int result = Integer.MIN_VALUE;
		for(int c1 = 0; c1 < matrix[0].length; c1++) {
			for(int c2 = c1; c2 < matrix[0].length; c2++) {
				int sum = 0;
				TreeSet<Integer> set = new TreeSet<>();
				set.add(0);
				
				for(int r = 0; r < matrix.length; r++) {
					sum += (c1 == 0) ? matrix[r][c2] : matrix[r][c2] - matrix[r][c1 - 1];
					Integer ceiling = set.ceiling(sum - limit);
					if(ceiling != null) {
						result = Math.max(result, sum - ceiling);
					}
					set.add(sum);
				}
			}
		}
		
		System.out.println(result);
	}
}
