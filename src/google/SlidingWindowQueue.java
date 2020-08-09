package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import stack.MaxStack;

public class SlidingWindowQueue {

	public static void main(String[] args) {

		int[] A = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int B = 3;

		List<Integer> result = new ArrayList<Integer>();
		MaxStack stack = new MaxStack();
		Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
		
		int i = 0;
		
		while (i < A.length) {
			queue.add(A[i]);
			stack.push(A[i]);
			
			if(queue.size() == B) {
				result.add(stack.max());
				int element = queue.poll();
				if(stack.max() == element) {
					stack.pop();
				}
			}
			
			i++;
		}
		
		for(Integer k : result) {
			System.out.print(k + ", ");
		}

	}
}
