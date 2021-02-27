package leetcode.google;

public class CupcakeDistribution {

	public static void main(String[] args) {

		// how many batches to prepare && how many groups will get fresh cupcakes
		int[] batches = { 5, 4 };
		int k = 2;

		int result = 0, leftovers = 0, fresh = 0;

		/**
		 * n%k ==0 && n/k > 0 [3/3], then result++ and no leftovers n%k > 0 &&
		 * n/k > 0 [4/3], then result++ and leftovers n%k > 0 && n/k == 0 [2/3],
		 * then leftovers
		 */
		for (int n : batches) {
			if (n % k == 0 && n / k > 0) {
				result++;
				if (leftovers == 0)
					fresh++;
			} else if (n % k > 0 && n / k > 0) {
				result++;
				if (leftovers == 0)
					fresh++;
				leftovers += n % k;
			} else if (n % k > 0 && n / k == 0) {
				if (leftovers == 0)
					fresh++;
				leftovers += n % k;
			}
			if (leftovers % k > 0) {
				result++;
			}
		}

		int batchesToMake = result + leftovers / result;
		System.out.println(batchesToMake);
		System.out.println(fresh);
	}
}
