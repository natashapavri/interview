package google;

public class HammingDistance {

	public static void main(String[] args) {

		// hamming distance in array
		int[] nums = { 2, 4, 6 };
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

		// hamming distance b/w integers
		int a = 9;
		int b = 14;

		result = a ^ b;
		int setBits = 0;
		while (result != 0) {
			setBits += result & 1;
			result >>= 1;
		}
		
		System.out.println(setBits);
	}
}
