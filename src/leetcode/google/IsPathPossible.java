package leetcode.google;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class IsPathPossible {

	public static void main(String[] args) {
		char[][] grid = new char[][] {{'R','R','R','R'},{'L','L','L','L'},{'R','R','R','R'},{'L','L','L','L'}};
		Map<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{-1, 0});
        map.put('D', new int[]{1, 0});
        map.put('R', new int[]{0, 1});
        map.put('L', new int[]{0, -1});
        int[][]directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		boolean isPossible = findPath(grid,visited, map);
		System.out.println(isPossible);
		visited = new boolean[grid.length][grid[0].length];
		int cost = findPathCost(grid, visited, directions);
		System.out.println(cost);
		
		grid = new char[][] {{'R','R','D'},{'D','L','L'},{'R','R','U'}};
		visited = new boolean[grid.length][grid[0].length];
		isPossible = findPath(grid,visited, map);
		System.out.println(isPossible);
		visited = new boolean[grid.length][grid[0].length];
		cost = findPathCost(grid, visited, directions);
		System.out.println(cost);
	}

	private static int findPathCost(char[][] grid, boolean[][] visited, int[][] directions) {
		Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		queue.add(new int[]{0,0,0});
		while(!queue.isEmpty()) {
			int[] point = queue.poll();
			char ch = grid[point[0]][point[1]];
			if(visited[point[0]][point[1]]) {
				continue;
			}
			
			if(point[0] == grid.length - 1 && point[1] == grid[0].length - 1) {
				return point[2];
			}
			visited[point[0]][point[1]] = true;
			for(int  i = 0; i < directions.length; i++) {
				int[] d = directions[i];
				int x = point[0] + d[0];
				int y = point[1] + d[1];
				
				if(x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[0].length - 1 && !visited[x][y]) {
					int flipCost = 0;
					if((i == 0 && ch == 'R') || (i == 1 && ch == 'L') || (i == 2 && ch == 'D') || (i == 3 && ch == 'U')) {
						flipCost = 0;
					} else {
						flipCost = 1;
					}
					queue.add(new int[] {x, y, point[2] + flipCost});
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	private static boolean findPath(char[][] grid, boolean[][] visited, Map<Character, int[]> map) {
		Queue<int[]> queue = new LinkedList<int[]>();		
		queue.add(new int[]{0,0});
		while(!queue.isEmpty()) {
			int[] point = queue.poll();
			char ch = grid[point[0]][point[1]];
			
			if(point[0] == grid.length - 1 && point[1] == grid[0].length - 1) {
				return true;
			}
			if(visited[point[0]][point[1]]) {
				continue;
			}
			visited[point[0]][point[1]] = true;
			int[] direction = map.get(ch);
			int x = point[0] + direction[0];
			int y = point[1] + direction[1];
			
			if(x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[0].length - 1 && !visited[x][y]) {
				queue.add(new int[]{x, y});
			}
		}
		return false;
	}
}
