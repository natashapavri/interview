package sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] nums = { -1, 4, 5, 0, 3, 2, 10 };
		sort(nums, 0, nums.length - 1);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ", ");
		}
	}

	private static void sort(int[] nums, int l, int r) {
		if (l < r) {
			int part_index = partition(nums, l, r);
			sort(nums, l, part_index - 1);
			sort(nums, part_index + 1, r);
		}
	}

	private static int partition(int[] nums, int l, int r) {
		int pivot = nums[r];
		int j = l - 1;
		for (int i = l; i < r; i++) {
			if (nums[i] < pivot) {
				j++;
				int t = nums[j];
				nums[j] = nums[i];
				nums[i] = t;
			}
		}

		int t = nums[j + 1];
		nums[j+1] = nums[r];
		nums[r] = t;
		
		return j + 1;
	}

}
