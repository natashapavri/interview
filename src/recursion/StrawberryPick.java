package recursion;

public class StrawberryPick {

	public static void main(String[] args) {
		int[] bushes = { 50, 10, 20, 30, 40 };
		int max = 100;

		int maxPicked = knapsack(bushes, bushes.length - 1, max);
		
		System.out.println(maxPicked);
	}

	private static int knapsack(int[] bushes, int n, int max) {
		if(n < 0 || max == 0) return 0;
		
		if(bushes[n] > max) {
			return knapsack(bushes, n - 1, max);
		} else {
			return Math.max(bushes[n] + knapsack(bushes, n - 1, max - bushes[n]), knapsack(bushes, n - 1, max));
		}
	}
}
