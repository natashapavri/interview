package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SingleNumberII {

	public static void main(String[] args) {
		int[] nums = { 1, 20, 4, 35, 35, 20, 20, 35, 1, 1 };
		int result = -1;

		// solution brute force
		// space = O(freq.size)
		// time = O(freq.size * n)
		result = getSingleNumberBrute(nums);
		System.out.println(result);

		// solution with math
		// time = O(nlogn)
		// space = O(n)
		result = getSingleNumberMath(nums);
		System.out.println(result);

		// solution with bit math
		// time = O(n)
		// space = O(1)
		result = getSingleNumberBit(nums);
		System.out.println(result);

	}

	/**
	 * Let us consider the example array {5, 5, 5, 8}. The 101, 101, 101, 1000
	 * Sum of first bits%3 = (1 + 1 + 1 + 0)%3 = 0; Sum of second bits%3 = (0 +
	 * 0 + 0 + 0)%0 = 0; Sum of third bits%3 = (1 + 1 + 1 + 0)%3 = 0; Sum of
	 * fourth bits%3 = (1)%3 = 1;
	 */
	private static int getSingleNumberBit(int[] nums) {
		int x = 0;
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			x = (1 << i);
			for (int j = 0; j < nums.length; j++) {
				if ((nums[j] & x) == 0)
					count++;
			}

			if (count % 3 == 0) {
				result |= x;
			}
		}
		return result;
	}

	private static int getSingleNumberMath(int[] nums) {
		Set<Integer> dedupe = new HashSet<Integer>();
		int sumWithoutDupes = 0;

		for (int i : nums) {
			if (!dedupe.contains(i)) {
				dedupe.add(i);
				sumWithoutDupes += i;
			}
		}

		int sumWithDupes = 0;
		for (int i = 0; i < nums.length; i++) {
			sumWithDupes += nums[i];
		}

		int result = (3 * sumWithoutDupes - sumWithDupes) / 2;
		return result;
	}

	private static int getSingleNumberBrute(int[] nums) {
		HashMap<Integer, Integer> freq = new HashMap<>();
		for (int i : nums) {
			freq.putIfAbsent(i, 0);
			int f = freq.get(i);
			freq.put(i, f + 1);
		}

		for (Integer n : freq.keySet()) {
			if (freq.get(n) == 1) {
				return n;
			}
		}
		return -1;
	}
}
