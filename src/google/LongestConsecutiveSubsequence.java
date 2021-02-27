package google;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2 };

		int count = 0, max = Integer.MIN_VALUE;

		Set<Integer> markers = new HashSet<Integer>();
		for (int i : nums) {
			markers.add(i);
		}

		for (int i = 0; i < nums.length; i++) {
			count = 0;

			if (!markers.contains(nums[i] - 1)) {
				int j = nums[i];
				while (markers.contains(j)) {
					j++;
					count++;
				}
				max = Math.max(count, max);
			}
			
		}

		System.out.println(max);
	}
}
