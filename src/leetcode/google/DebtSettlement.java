package leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DebtSettlement {

	public static void main(String[] args) {
		int[][] transactions = { { 0, 1, 10 }, { 1, 0, 1 }, { 1, 2, 5 }, { 2, 0, 5 } };
		Map<Integer, Integer> txns = new HashMap<>();
		for (int[] arr : transactions) {
			txns.put(arr[0], txns.getOrDefault(arr[0], 0) - arr[2]);
			txns.put(arr[1], txns.getOrDefault(arr[1], 0) + arr[2]);
		}

		List<Integer> debts = new ArrayList<>();
		for (Integer value : txns.values()) {
			if (value != 0)
				debts.add(value);
		}

		int[] debt = new int[debts.size()];
		int k = 0;
		for (Integer i : debts) {
			debt[k++] = i;
		}
		int result = dfs(debt, 0, 0);

		System.out.println(result);
	}

	private static int dfs(int[] debts, int pos, int count) {
		while (pos < debts.length && debts[pos] == 0)
			pos++;
		if (pos == debts.length) {
			return count;
		}
		int result = Integer.MAX_VALUE;
		for (int i = pos + 1; i < debts.length; i++) {
			if (debts[i] * debts[pos] < 0) {
				debts[i] = debts[pos] + debts[i];
				result = Math.min(result, dfs(debts, pos + 1, count + 1));
			}
		}
		return result;
	}

}
