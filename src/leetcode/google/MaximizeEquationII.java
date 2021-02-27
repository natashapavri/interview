package leetcode.google;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeEquationII {

	public static void main(String[] args) {
		int[][] points = {{1,3},{2,0},{5,10},{6,-10}};
		int k = 1;
		
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		
		// current point is j and old point is i. queue contains - [diff equation(yi - xi), old point(xi)]
		int max = Integer.MIN_VALUE;
		for(int[] point : points) {
			while(!queue.isEmpty() && point[0] - queue.peek()[1] > k) {
				queue.poll();
			}
			if(!queue.isEmpty()) {
				int equation = point[0] + point[1] + queue.peek()[0];
				max = Math.max(max, equation);
			}
			queue.add(new int[] {point[1] - point[0], point[0]});
		}
		
		System.out.println(max);
	}
}
