package google;

public class MinMaxLeastComparisons {

	/**
	 * #comparisons ==>
	 * Odd elements = 3 ifs * (n-1 (one number is done)/2
	 * Even elements = 1(initial comparison) + 3 ifs*(n-2 (2 numbers are done)/2
	 * Time complexity = O(n)
	 */
	public static void main(String[] args) {
		int[] nums = { -2, 1, -4, 5, 3 };

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		int i = 0;
		if (nums.length % 2 == 0) {
			if (nums[0] > nums[1]) {
				min = nums[1];
				max = nums[0];
			} else {
				min = nums[0];
				max = nums[1];
			}
			i = 2;
		} else {
			min = nums[0];
			max = nums[0];
			i = 1;
		}

		for (int j = i; j < nums.length - 1; j += 2) {
			if (nums[j] > nums[j + 1]) {
				if (nums[j] > max) {
					max = nums[j];
				}
				if (nums[j + 1] < min) {
					min = nums[j + 1];
				}
			} else {
				if (nums[j + 1] > max) {
					max = nums[j + 1];
				}
				if (nums[j] < min) {
					min = nums[j];
				}
			}
		}

		System.out.println(min);
		System.out.println(max);
	}

}
