package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		Set<List<Integer>> results = findSums(nums, target);

		for (List<Integer> sum : results) {
			for (Integer i : sum) {
				System.out.print(i + ", ");
			}
			System.out.println();
		}
	}

	private static Set<List<Integer>> findSums(int[] nums, int target) {
		Set<List<Integer>> results = new HashSet<>();
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i == j)
					continue;
				for (int k = 0; k < nums.length; k++) {
					if (j == k)
						continue;
					for (int l = 0; l < nums.length; l++) {
						if (k == l)
							continue;

						if (nums[i] < nums[j] && nums[j] <= nums[k] && nums[k] < nums[l]) {
							if(nums[i] + nums[j] + nums[k] + nums[l] == target) {
								List<Integer> sum = new ArrayList<Integer>();
								sum.add(nums[i]);
								sum.add(nums[j]);
								sum.add(nums[k]);
								sum.add(nums[l]);
								results.add(sum);
							}
						}
					}
				}
			}
		}
		return results;
	}

}
