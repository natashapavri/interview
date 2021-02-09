package leetcode.google;

import java.util.HashSet;
import java.util.Set;

public class DistributeRepeatedNumbers {

	public static void main(String[] args) {
		int[] f = new int[1001];
		f[0] = 8;
		f[1] = 10;
		int[] quantity = { 2, 3, 3, 3, 7 };
		Set<Integer> set = new HashSet<>();
		for (int i : quantity) {
			set.add(i);
		}
		boolean result = dfs(0, set, f, quantity);
		System.out.println(result);
	}

	public static boolean dfs(int idx, Set<Integer> set, int[] f, int[] quantity) {
		if (idx == quantity.length)
			return true;

		Set<Integer> visitF = new HashSet<>();

		for (int num : set) { // not loop from 1-1000, because at most 50 unique
								// numbers
			if (f[num] < quantity[idx])
				continue;
			if (visitF.contains(f[num]))
				continue; // no necessary to re-use the same frequency
			visitF.add(f[num]);
			f[num] = f[num] - quantity[idx];
			if (dfs(idx + 1, set, f, quantity)) {
				return true;
			}
			f[num] = f[num] + quantity[idx];
		}

		return false;
	}
}
