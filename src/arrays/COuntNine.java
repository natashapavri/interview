package arrays;

public class COuntNine {

	public static void main(String[] args) {
		int[]nums = {1,9,5,6,7};
		System.out.println(arrayFront9(nums));
	}
	public static boolean arrayFront9(int[] nums) {
		if (nums == null || nums.length < 4)
			return false;
		for (int i = 0; i < 4; i++) {
			if (nums[i] == 9)
				return true;
		}
		return false;
	}

}
