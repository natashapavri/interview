package google;

import java.util.Arrays;

public class SingleNumberI {

	public static void main(String[] args) {
		int[] nums = {1,2,2,1,3,4,3};
		
		int result = 0;
		for(int i = 0;i<nums.length;i++) {
			result = result ^ nums[i];
		}
		
		System.out.println(result);
		
		// sorting is needed to achieve O(logn) time 
		Arrays.sort(nums);
		int number = findSingleNumberinLogNTime(nums);
		System.out.println(number);
	}

	private static int findSingleNumberinLogNTime(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		
		while(l < r) {
			int mid = l + (r - l) / 2;
			boolean halfEvenLength = ((r - mid) % 2 == 0);
			
			if(nums[mid] == nums[mid + 1]) {
				if(halfEvenLength) {
					l = mid + 2;
				} else {
					r = mid - 1;
				}
			} else if(nums[mid] == nums[mid - 1]) {
				if(halfEvenLength) {
					r = mid - 2;
				} else {
					l = mid + 1;
				}
			} else {
				return nums[mid];
			}
		}
		return nums[l];
	}
}
