
public class PrefixSumArray {

	public static void main(String[] args) {
		int[] nums = {10,20,30,40,50};
		int [] result = prefixSum(nums);
		for(int i : result) {
			System.out.print(i + ", ");
		}
	}

	private static int[] prefixSum(int[] nums) {
		int [] result = new int[nums.length];
		result[0] = nums[0];
		for(int i=1;i<nums.length;i++) {
			result[i] = result[i-1]+nums[i];
		}
		return result; 
	}
}
