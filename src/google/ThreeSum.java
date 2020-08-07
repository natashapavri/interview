package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		Set<List<Integer>> results = findZeroSums(nums);

		for (List<Integer> s : results) {
			for (Integer i : s) {
				System.out.print(i + ", ");
			}

			System.out.println();
		}
	}

	private static Set<List<Integer>> findZeroSums(int[] nums) {
		Set<List<Integer>> results = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i == j)
					continue;
				for (int k = 0; k < nums.length; k++) {
					if (j == k)
						continue;
					if (nums[i] <= nums[j] && nums[j] <= nums[k]) {
						if (nums[i] + nums[j] + nums[k] == 0) {
							List<Integer> sum = new ArrayList<>();
							sum.add(nums[i]);
							sum.add(nums[j]);
							sum.add(nums[k]);
							results.add(sum);
						}
					}
				}
			}
		}

		return results;
	}

}
