package leetcode.google;

public class MaxUnhealthyPeriod {

	public static void main(String[] args) {
		int[] input = {10, 2, 3, 5, 1, 7, 4, 8}; //, k = 5); //== 12;
		// int[] input = {10, 2, 3, 5, 1, 7, 4, 8}; // k = 4 // == 8;
		// int[] input = {5, 4, 2, 10} ; // , 2) == 8;
		// int[] input = {1, 2, 3}; // , 2) == 4;
		// int[] input = { 1, 2, 3, 4, 5, 6 }; // , 3) == 12;

		int[] min = new int[input.length];
		int k = 5;
		int mn = input[k];
		for (int i = k; i >= 0; i--) {
			mn = Math.min(input[i], mn);
			min[i] = mn;
		}
		mn = input[k];
		for (int j = k; j < input.length; j++) {
			mn = Math.min(input[j], mn);
			min[j] = mn;
		}
		int tot = 0;
		for (int m = 0; m <= k; m++) {
			int mint = min[m];
			int sum = mint * (k - m + 1);
			tot = Math.max(tot, sum);
		}

		for (int n = k; n < input.length; n++) {
			int mint = min[n];
			int sum = mint * (n - k + 1);
			tot = Math.max(tot, sum);
		}
		System.out.println(tot);
	}

}
