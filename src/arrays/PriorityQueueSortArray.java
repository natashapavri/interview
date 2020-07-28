package arrays;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueSortArray {

	public static void main(String[] args) {
		Integer[] arr1 = {2,3,4};
		Integer[] arr2 = {5,6,7};
		Integer[] arr3 = {4,7,9};
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.addAll(Arrays.asList(arr1));
		queue.addAll(Arrays.asList(arr2));
		queue.addAll(Arrays.asList(arr3));
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
