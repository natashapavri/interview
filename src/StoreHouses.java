import java.util.Arrays;

public class StoreHouses {

	public static void main(String[] args) {
		int[] houses = { 4, 8, 1, 1 };
		int[] stores = { 5, 3, 1, 2, 6 };

		Arrays.sort(houses);
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
			int high = stores.length;

			while (low < high) {
				int mid = (low + high) / 2;
				int diff = Math.abs(houses[i] - stores[mid]);
				if (houses[i] == stores[mid]) {
					results[i] = stores[mid];
					break;
				}
				if (minDiff > diff) {
					minDiff = diff;
					results[i] = stores[mid];
				}
				if (diff < stores[mid]) {
					high = mid;
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
