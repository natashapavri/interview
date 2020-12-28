package arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class EuclideanDistance {

	public static void main(String[] args) {
		
		int[][] points = {{3,3},{5,1},{-2,4}};
		int k = 2;
		
		//maxheap because queue is fifo and we will be polling extra elements over k. Hence we need the first element to be largest distance so it can be dropped off.
		//for maxheap comparator will have y-x
		PriorityQueue<int[]> distance = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return distance(o2) - distance(o1);
			}

			private int distance(int[] o) {
				return (o[0]*o[0])+(o[1]*o[1]);
			}
		});
		
		for(int[] arr : points) {
			distance.add(arr);
			if(distance.size() > k) {
				distance.poll();
			}
		}
		
		for(int[] arr : distance) {
			for(int j = 0;j<arr.length;j++) {
				System.out.print(arr[j]+",");
			}
		}
		
		
	}
}
