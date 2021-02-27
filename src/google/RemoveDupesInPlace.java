package google;

public class RemoveDupesInPlace {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 3 };
		int i = 0, j = 1;

		while (i < nums.length && j < nums.length) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
			j++;
		}

		for (int k = 0; k <= i; k++) {
			System.out.println(nums[k]);
		}

	}
}
