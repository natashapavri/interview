package sort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] nums = { -1, 4, 5, 0 , 3, 2, 10 };

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
				}
			}
		}

		for (int k = 0; k < nums.length; k++) {
			System.out.print(nums[k] + ", ");
		}
	}
}
