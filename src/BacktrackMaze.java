
public class BacktrackMaze {

	public static void main(String[] args) {
		int[][] maze = {{1,1},{1,0},{1,1},{1,1}};
		
		int[][] solution = new int[maze.length][maze[0].length];
		
		boolean solve = solve(maze,0,0, solution);
		if(solve) {
			for(int i=0;i<solution.length;i++) {
				for(int j=0;j<solution[0].length;j++) {
					System.out.print(solution[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	private static boolean solve(int[][] maze, int i, int j, int[][] solution) {
		if(i == maze.length-1 && j==maze[0].length -1 && maze[i][j] == 1) {
			solution[i][j] = 1;
			return true;
		}
		
		if(isSafe(maze, i, j)) {
			solution[i][j] = 1;
			if(solve(maze, i+1, j, solution)) {
				return true;
			}
			if(solve(maze, i, j+1, solution)) {
				return true;
			}
			solution[i][j] = 0;
			return false;
		}
		return false;
	}

	private static boolean isSafe(int[][] maze, int i, int j) {
		return (i >=0 && i<maze.length && j>=0 && j<maze[0].length && maze[i][j] == 1);
	}
}
