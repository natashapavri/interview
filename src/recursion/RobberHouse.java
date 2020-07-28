package recursion;

public class RobberHouse {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 9, 3, 1 };
		int maxRob = knapsack(nums, 0);

		System.out.println(maxRob);
	}

	private static int knapsack(int[] nums, int i) {
		if (i > nums.length - 2)
			return 0;

		return Math.max(nums[i] + knapsack(nums, i + 2), knapsack(nums, i + 1));
	}

}
