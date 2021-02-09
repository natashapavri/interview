package arrays;

import java.util.ArrayList;
import java.util.List;

public class LongestSubSequence {

	public static void main(String[] args) {
		int[] nums = { 5, 2, 4, 3, 1, 6 };

		increasingSubsequence(nums);
		decreasingSubsequence(nums);
	}

	private static void increasingSubsequence(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		int[] lis = new int[nums.length];
		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
			list.add(new ArrayList<>());
		}
		
		list.get(0).add(nums[0]);
		
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[i]>nums[j] && lis[i]<lis[j] + 1) {
					lis[i] = lis[j]+1;
					list.set(i, new ArrayList<>(list.get(j)));
				}
			}
			list.get(i).add(nums[i]);
		}
		
		int max = Integer.MIN_VALUE;
		for(int k=0;k<lis.length;k++) {
			max = Math.max(max, lis[k]);
		}
		System.out.println(max);
		
		List<Integer> maxList = list.get(0);
		for(List<Integer> l : list) {
			if(l.size() > maxList.size()) {
				maxList = l;
			}
		}
		System.out.println(maxList);
		
		
	}
	
	private static void decreasingSubsequence(int[] nums) {
		int[] lis = new int[nums.length];
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
			list.add(new ArrayList<>());
		}
		
		list.get(0).add(nums[0]);
		
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[i]<nums[j] && lis[i]<lis[j] + 1) {
					lis[i] = lis[j]+1;
					list.set(i, new ArrayList<>(list.get(j)));
				}
			}
			list.get(i).add(nums[i]);
		}
		
		int max = Integer.MIN_VALUE;
		for(int k=0;k<lis.length;k++) {
			max = Math.max(max, lis[k]);
		}
		
		System.out.println(max);
		
		List<Integer> maxList = list.get(0);
		for(List<Integer> l : list) {
			if(l.size() > maxList.size()) {
				maxList = l;
			}
		}
		System.out.println(maxList);
	}
}
