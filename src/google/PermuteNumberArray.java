package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuteNumberArray {

	public static void main(String[] args) {

		PermuteNumberArray soa = new PermuteNumberArray();
		int[] nums = { 1, 2, 3 };
		Set<List<Integer>> subsets = soa.subsets(nums);

		for (List<Integer> subset : subsets) {
			System.out.println(subset);
		}
	}

	public Set<List<Integer>> subsets(int[] nums) {
		Set<List<Integer>> list = new HashSet<>();
		subsetsHelper(list, new ArrayList<>(), nums);
		return list;
	}

	Set<Integer> check = new HashSet<>();

	private void subsetsHelper(Set<List<Integer>> list, List<Integer> resultList, int[] nums) {
		if (resultList.size() == nums.length) {
			list.add(new ArrayList<>(resultList));
		}

		for (int i = 0; i < nums.length; i++) {
			if (!check.contains(i)) {

				// add element
				resultList.add(nums[i]);
				check.add(i);
				
				// Explore
				subsetsHelper(list, resultList, nums);
				
				// remove
				check.remove(i);
				resultList.remove(resultList.size() - 1);
			}
		}
	}

}