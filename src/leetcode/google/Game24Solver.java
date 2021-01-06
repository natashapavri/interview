package leetcode.google;

public class Game24Solver {

	// time complexity = O(1)
	// space complexity = O(1)
	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 1 };
		double[] input = new double[nums.length];
		int k = 0;
		for (int i : nums) {
			input[k++] = i;
		}
		boolean isPossible = solve(input);
		System.out.println(isPossible);
	}

	private static boolean solve(double[] input) {

		if (input.length == 1)
			return Math.abs(input[0] - 24) < 0.0000001;

		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				double a = input[i];
				double b = input[j];
				double[] rest = new double[input.length - 1];
				for (int k = 0, index = 0; k < input.length; k++) {
					if (k != i && k != j) {
						rest[index++] = input[k];
					}
				}

				double[] results = compare(a, b);
				for (double d : results) {
					rest[rest.length - 1] = d;
					if (solve(rest)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private static double[] compare(double a, double b) {
		return new double[] { a + b, a - b, a * b, a / b, b - a, a / b, b / a };

	}

}
