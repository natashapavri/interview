package arrays;

import java.util.Arrays;

public class StoreHouses {

	public static void main(String[] args) {
		int[] houses = { 4, 8, 1, 1 };
		int[] stores = { 5, 3, 1, 2, 6 };

		Arrays.sort(stores);

		int[] results = new int[houses.length];
		for (int i = 0; i < houses.length; i++) {
			int minDiff = Integer.MAX_VALUE;
			// for (int j = 0; j < stores.length; j++) {
			// int diff = Math.abs(houses[i] - stores[j]);
			// if (minDiff > diff) {
			// minDiff = diff;
			// results[i] = stores[j];
			// }
			// }
			int low = 0;
			int high = stores.length - 1;

			while (low <= high) {
				int mid = (low + high) / 2;
				int diff = Math.abs(houses[i] - stores[mid]);
				if (houses[i] == stores[mid]) {
					results[i] = stores[mid];
					break;
				}
				if (diff == minDiff) {
					results[i] = Math.min(results[i], stores[mid]);
				} else if (minDiff > diff) {
					minDiff = diff;
					results[i] = stores[mid];
				}
				/**
				 * stores are sorted in ascending order. So if houses[i] >
				 * stores[mid] then you have to increase the stores[mid] to
				 * minimize the diff. So we have to move left ahead.
				 */
				if (stores[mid] > houses[i]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}

		for (int i = 0; i < results.length; i++) {
			System.out.print(results[i] + ", ");
		}
	}
}
