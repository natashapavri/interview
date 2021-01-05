package leetcode.google;

import java.util.TreeSet;

public class MaximumSumNotLargerThan {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 6, 7 };
		int limit = 11;

		TreeSet<Integer> set = new TreeSet<>();
		set.add(0);

		int sum = 0;
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			Integer ceiling = set.ceiling(sum - limit);
			if (ceiling != null) {
				result = Math.max(result, sum - ceiling);
			}
			set.add(sum);
		}

		System.out.println(result);
	}

}
