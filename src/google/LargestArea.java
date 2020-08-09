package google;

import java.util.Stack;

public class LargestArea {

	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		
		int maxArea = Integer.MIN_VALUE;
		int i = 0;
		Stack<Integer> indexStack = new Stack<>();
		
		while(i < heights.length) {
			if(indexStack.isEmpty() || heights[indexStack.peek()] <= heights[i]) {
				indexStack.push(i++);
			} else {
				int currMax = indexStack.peek();
				indexStack.pop();
				
				int area = heights[currMax] * (indexStack.isEmpty() ? i : (i - 1 - indexStack.peek()));
				if(maxArea < area) {
					maxArea = area;
				}
			}
		}
		
		while(!indexStack.isEmpty()) {
			int currMax = indexStack.peek();
			indexStack.pop();
			
			int area = heights[currMax] * (indexStack.isEmpty() ? i : (i-1-indexStack.peek()));
			if(area > maxArea) {
				maxArea = area;
			}
		}
		
		System.err.println(maxArea);
		
	}
}