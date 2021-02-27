package sort;

public class MergeSort {

	/**
	 * Time complexity = O(nlogn)
	 * Space complexity = O(n)
	 * 
	 */
	public static void main(String[] args) {
		int[] nums = { -1, 4, 5, 0, 3, 2, 10 };

		int l = 0;
		int r = nums.length - 1;

		sort(nums, l, r);

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ", ");
		}

	}

	private static void sort(int[] nums, int l, int r) {

		if (l < r) {
			int m = (l + r) / 2;
			sort(nums, l, m);
			sort(nums, m + 1, r);
			merge(nums, l, m, r);
		}

	}

	private static void merge(int[] nums, int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = nums[l + i];
		}

		for (int j = 0; j < n2; j++) {
			R[j] = nums[m + 1 + j];
		}

		int k = l;
		int i = 0, j = 0;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				nums[k++] = L[i];
				i++;
			} else {
				nums[k++] = R[j];
				j++;
			}
		}
		
		while(i<n1) {
			nums[k++] = L[i++];
		}
		
		while(j<n2) {
			nums[k++] = R[j++];
		}
	}
}
