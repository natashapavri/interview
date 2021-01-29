package recursion;

public class KnapsackPizzaShop {

	public static void main(String[] args) {
		int[] pizza = { 800, 850, 900 };
		int[] topping = { 100, 150 };
		int amount = 1000;

		int[] cost = new int[pizza.length * topping.length];
		int k = 0;
		for (int i = 0; i < pizza.length; i++) {
			for (int j = 0; j < topping.length; j++) {
				cost[k++] = pizza[i] + topping[j];
			}
		}

		int maxCost = knapsack(cost, amount, cost.length - 1);

		System.out.println(maxCost);
	}

	private static int knapsack(int[] cost, int amount, int n) {

		if (amount == 0 || n == 0)
			return 0;

		if (cost[n] > amount) {
			return knapsack(cost, amount, n - 1);
		} else {
			return Math.max(cost[n] + knapsack(cost, amount - cost[n], n - 1), knapsack(cost, amount, n - 1));
		}
	}
}
