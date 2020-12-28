package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumAmplitudeChange {

	public static void main(String[] args) {
		int[] nums = { -1, 3, - 1, 8, 5, 4 };
		
		PriorityQueue<Integer> minQueue = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
		
		for(int n : nums) {
			minQueue.add(n);
			if(minQueue.size() > 4) {
				minQueue.poll();
			}
			maxQueue.add(n);
			if(maxQueue.size() > 4) {
				maxQueue.poll();
			}
		}
		
		List<Integer> minList = new ArrayList<>();
		List<Integer> maxList = new ArrayList<>();
		
		while(!minQueue.isEmpty()) {
			minList.add(minQueue.poll());
		}
		while(!maxQueue.isEmpty()) {
			maxList.add(maxQueue.poll());
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < 4; i++) {
			ans = Math.min(ans, (maxList.get(i) - minList.get(3 - i)));
		}
		
		System.out.println(ans);
	}
}
