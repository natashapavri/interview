package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatedSubsequenceWithReplacement {

	// for strings =
	// https://leetcode.com/problems/longest-repeating-character-replacement/discuss/1022193/Very-simple-sliding-window-solution-7-lines-Java-code-(with-explanation)
	public static void main(String[] args) {
		int[] nums = { 1, 2, 7, 8, 3, 45 };
		int k = 3;

		int maxFreq = Integer.MIN_VALUE;
		Map<Integer, Integer> freq = new HashMap<>();
		int win_length = Integer.MIN_VALUE;
		for (int start = 0, end = 0; end < nums.length; end++) {
			freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);
			maxFreq = Math.max(maxFreq, freq.get(nums[end]));
			if (end - start + 1 - maxFreq > k) {
				freq.put(nums[start], freq.getOrDefault(nums[start], 0) - 1);
				start++;
			}
			win_length = Math.max(win_length, end - start + 1);
		}

		System.out.println(win_length);
	}
}
