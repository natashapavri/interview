package leetcode.google;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestSubarrayWithDiff {

	//https://www.youtube.com/watch?v=LDFZm4iB7tA
	public static void main(String[] args) {
		int[] nums = {10,1,2,4,7,2};
		int limit = 5;
		int result = longestSubarray(nums, limit); 
		System.out.println(result);
	}
	public static int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b.compareTo(a);
			}
		});
        PriorityQueue<Integer> min = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        });
        
        int start = 0, end = 0;
        min.add(nums[start]);
        max.add(nums[start]);
        int ans = Integer.MIN_VALUE;
        while(start < nums.length && end < nums.length) {
            int diff = max.peek() - min.peek();
            if(diff <= limit) {
                ans = Math.max(ans, end-start + 1);
                end++;
                if(end < nums.length) {
                    max.add(nums[end]);
                    min.add(nums[end]);    
                }
                
            } else {
                
                if(max.peek() == nums[start]) {
                    max.poll();
                }
                if(min.peek() == nums[start]) {
                    min.poll();
                }
                start++;
            }
        }
        
        return ans;
    }
}
