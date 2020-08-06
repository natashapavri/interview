package google;

public class HammingDistance {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5 };
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < nums.length; j++) {
				if ((nums[j] & (1 << i)) == 0) {
					count++;
				}
			}
			result += count * (nums.length - count) * 2;
		}

		System.out.println(result);
	}
}
