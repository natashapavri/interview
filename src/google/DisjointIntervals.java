package google;

public class DisjointIntervals {

	public static void main(String[] args) {
		int[][] nums = { { 1, 4 }, { 2, 3 }, { 4, 6 }, { 8, 9 }, { 20, 21 } };

		int count = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i][0] < nums[i - 1][0] || nums[i][1] > nums[i - 1][1]) {
				count += 1;
			}
		}

		System.out.println(count + 1);
	}
}
