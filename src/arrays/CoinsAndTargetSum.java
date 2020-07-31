package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinsAndTargetSum {

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };
		int target = 520;

		Arrays.sort(coins);

		List<Integer> selected = new ArrayList<>();

		for (int i = coins.length - 1; i >= 0; i--) {
			if (coins[i] > target)
				continue;
			if (coins[i] == target) {
				selected.add(coins[i]);
				break;
			}
			while (coins[i] < target) {
				selected.add(coins[i]);
				target -= coins[i];
			}
		}

		for (Integer c : selected) {
			System.out.print(c + ", ");
		}
	}
}
