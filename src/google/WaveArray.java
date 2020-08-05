package google;

import java.util.Arrays;

public class WaveArray {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, -5, 10};
		
		Arrays.sort(nums);
		
		for(int i = 0; i<nums.length; i+=2) {
			swap(i, i+1, nums);
		}
		
		for(int i = 0;i<nums.length;i++) {
			System.out.print(nums[i] + ", ");
		}
	}
	
	private static void swap(int i, int j, int[] nums) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}
