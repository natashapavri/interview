package google;

public class ChocolateDivide {

	public static void main(String[] args) {
		int[] sweetness = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int K = 5;
		int ans = maximizeSweetness(sweetness, K);
		System.out.println(ans);
	}

	private static int maximizeSweetness(int[] sweetness, int K) {
		int total = 0;

		for (int i = 0; i < sweetness.length; i++) {
			total += sweetness[i];
		}

		int ans = Integer.MIN_VALUE;
		int left = 1; // minimum sweetness in array
		int right = total;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (isPossible(sweetness, mid, K)) {
				ans = Math.max(ans, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return ans;
	}

	private static boolean isPossible(int[] sweetness, int mid, int K) {
		int current = 0;
		int maxSum = mid;

		int cuts = 0;

		for (int i = 0; i < sweetness.length; i++) {
			current = current + sweetness[i];
			if (current >= maxSum) {
				cuts++;
				current = 0;
			}
		}

		return cuts >= K + 1;
	}
}
