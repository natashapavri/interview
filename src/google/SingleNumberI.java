package google;

public class SingleNumberI {

	public static void main(String[] args) {
		int[] nums = {1,2,2,1,3,4,3};
		
		int result = 0;
		for(int i = 0;i<nums.length;i++) {
			result = result ^ nums[i];
		}
		
		System.out.println(result);
	}
}
