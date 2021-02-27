package leetcode.google;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostForValidPath {

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 2, 2, 2, 2 } };
		int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int minCost = getMinCost(grid, directions);
		System.out.println(minCost);
	}

	private static int getMinCost(int[][] grid, int[][] directions) {
		PriorityQueue<PathCost> queue = new PriorityQueue<>(new Comparator<PathCost>() {

			@Override
			public int compare(PathCost o1, PathCost o2) {
				return o1.getCost() - o2.getCost();
			}
		});

		queue.add(new PathCost(0, 0, 0));
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		while (!queue.isEmpty()) {
			PathCost current = queue.poll();
			visited[current.x][current.y] = true;
			
			if(current.x == grid.length - 1 && current.y == grid[0].length - 1) {
				return current.cost;
			}
			
			for(int  i = 0; i < directions.length; i++) {
				int newX = current.x + directions[i][0];
				int newY = current.y + directions[i][1];
				
				if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !visited[newX][newY]) {
					int flipCost = i + 1 == grid[current.x][current.y] ? 0 : 1;
					queue.add(new PathCost(current.cost + flipCost, newX, newY));
				}
			}
		}
		
		return -1;
	}
}

class PathCost {
	int cost;
	int x;
	int y;

	public PathCost(int cost, int x, int y) {
		super();
		this.cost = cost;
		this.x = x;
		this.y = y;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "PathCost [cost=" + cost + ", x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cost;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PathCost other = (PathCost) obj;
		if (cost != other.cost)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}