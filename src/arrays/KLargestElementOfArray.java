package arrays;
import java.util.PriorityQueue;

public class KLargestElementOfArray {

	public static void main(String[] args) {
		int[] nums = { 2, 6, 14, 5, 6 };
		int m = 2;
		int result = findLargest(nums, m);
		System.out.println(result);
	}

	private static int findLargest(int[] nums, int m) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i =0;i<nums.length;i++) {
			queue.add(nums[i]);
		}
		
		while(queue.size() > m) {
			queue.poll();
		}
		
		return queue.peek();
	}
}
