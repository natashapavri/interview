package arrays;

public class TwoPointersSum {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 2, 5, 1, 1, 2, 3 };
		int sum = 8;

		int l = 0;
		int r = l + 1;

		int prefixSum = nums[l];
		while (l < r) {
			prefixSum = prefixSum + nums[r];
			if (prefixSum < sum) {
				r++;
			}
			if (prefixSum == sum) {
				break;
			}
			if (prefixSum > sum) {
				while (prefixSum > sum) {
					prefixSum = prefixSum - nums[l];
					l++;
				}
				r++;
			}
		}

		for (int i = l; i <= r; i++) {
			System.out.print(nums[i] + ",");
		}
	}
}
