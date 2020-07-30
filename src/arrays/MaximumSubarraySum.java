package arrays;

public class MaximumSubarraySum {

	public static void main(String[] args) {
		int[] nums = { -1, 2, 4, -3, 5, 2, -5, 2 };
		int max_so_far = 0, max_as_of_here = 0;

		for (int i = 0; i < nums.length; i++) {
			max_as_of_here = max_as_of_here + nums[i];
			if(max_so_far < max_as_of_here) {
				max_so_far = max_as_of_here;
			}
			if(max_as_of_here < 0) {
				max_as_of_here = 0;
			}
		}
		
		System.out.println(max_so_far);
	}
}
