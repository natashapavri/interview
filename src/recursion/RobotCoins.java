package recursion;

public class RobotCoins {

	public static void main(String[] args) {
		int[][] grid1 = {{9, 10, 15, 12, 11},
				{7, 5, 11, 6, 8},
				{4, 1, 27, 13, 17},
				{2, 4, 18, 2, 1},
				{15, 3, 22, 6, 10},
				{8, 2, 5, 9, 6}};
		
		int[][] grid2 = {{3, 6, 8, 2},
				 {5, 2, 4, 3},
				 {1, 1, 20, 10},
				 {1, 1, 20, 10},
				 {1, 1, 20, 10}};
		
		Integer[][][]cache1 = new Integer[grid1.length][grid1[0].length][grid1[0].length];
		int maxCoins = traverse(grid1, 0, 0, grid1[0].length-1, cache1);
		System.out.println(maxCoins);
		Integer[][][]cache2 = new Integer[grid2.length][grid2[0].length][grid2[0].length];
		maxCoins = traverse(grid2, 0, 0, grid2[0].length-1,cache2);
		System.out.println(maxCoins);
	}

	private static int traverse(int[][] grid, int row, int col1, int col2, Integer[][][]cache) {
		
		if(row >= grid.length || col1 < 0 || col1 >=grid[0].length || col2 < 0 || col2 >= grid[0].length)
			return Integer.MIN_VALUE;
		
		if(cache[row][col1][col2] != null) return cache[row][col1][col2];
		
		int maxCoins = 0;
		
		if(row == grid.length -1 && col1 == 0 && col2 == grid[0].length -1) {
			return grid[row][col1] + grid[row][col2];
		}
		
		if(col2 == col1) {
			maxCoins+= grid[row][col1];
		} else {
			maxCoins+= grid[row][col1] + grid[row][col2];
		}
		int next = 
			Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(traverse(grid, row+1, col1,col2,cache),
			traverse(grid, row+1, col1, col2-1,cache))
			,traverse(grid, row+1, col1, col2+1,cache))
			,traverse(grid, row+1, col1+1, col2,cache))
			,traverse(grid, row+1, col1+1, col2-1,cache))
			,traverse(grid, row+1, col1+1, col2+1,cache))
			,traverse(grid, row+1, col1-1, col2,cache))
			,traverse(grid, row+1, col1-1, col2-1,cache))
			,traverse(grid, row+1, col1-1, col2+1,cache));

		
		maxCoins+=next;
		cache[row][col1][col2] = new Integer(maxCoins);
		
		return maxCoins;
	}
}
