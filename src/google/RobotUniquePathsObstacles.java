package google;

public class RobotUniquePathsObstacles {

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

		// if first cell is obstacle return no paths
		if (grid[0][0] == 1) {
			System.out.println(0);
			return;
		} else {
			grid[0][0] = 1;
		}

		// check first row
		for (int j = 1; j < grid[0].length; j++) {
			if (grid[0][j] == 0 && grid[0][j - 1] == 1) {
				grid[0][j] = 1;
			}
		}

		// check first column
		for (int i = 1; i < grid.length; i++) {
			if (grid[i][0] == 0 && grid[i-1][0] == 1) {
				grid[i][0] = 1;
			}
		}
		
		for(int i = 1; i < grid.length; i++) {
			for(int j = 1; j < grid[0].length; j++) {
				if(grid[i][j] == 0) {
					grid[i][j] = grid[i-1][j] + grid[i][j-1];
				} else {
					grid[i][j] = 0;
				}
			}
		}
		
		System.out.println(grid[grid.length - 1][grid[0].length - 1]);
	}
}
