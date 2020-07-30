package sort;

public class SelectionSort {

	public static void main(String[] args) {
		int[] nums = { -1, 4, 5, 0, 3, 2, 10 };

		for (int i = 0; i < nums.length - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[min_idx]) {
					min_idx = j;
				}
			}

			int t = nums[min_idx];
			nums[min_idx] = nums[i];
			nums[i] = t;
		}

		for (int k = 0; k < nums.length; k++) {
			System.out.print(nums[k] + ", ");
		}
	}
}
