package arrays;

public class TwoPointersSum {

	public static void main(String[] args) {
		int[] nums = {1, 3, 2, 5, 1, 1, 2, 3};
		int sum = 8;
		
		int l = 0;
		int r = l+1;
		
		int slidingSum = nums[l];
		while(l<r) {
			slidingSum= slidingSum+nums[r];
			if(slidingSum<sum) {
				r++;
			}
			if(slidingSum == sum) {
				break;
			}
			if(slidingSum>sum) {
				while(slidingSum>sum) {
					slidingSum = slidingSum - nums[l];
					l++;
				}
				r++;
			}
		}
		
		for(int i=l;i<=r;i++) {
			System.out.print(nums[i]+",");
		}
	}
}
