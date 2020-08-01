package arrays;

public class RangeQueryArray {

	public static void main(String[] args) {
		int[] nums = {1, 3, 4, 8, 6, 1, 4, 2};
		int lower = 2;
		int upper = 5;
		
		int min = findMinInRange(nums, lower, upper);
		System.out.println(min);
	}

	private static int findMinInRange(int[]nums, int lower, int upper) {
		int min = Integer.MAX_VALUE;
		int k = closestPowerOfTwo(upper - lower + 1);
		int nextUpper = upper - k + 1;
		int nextLower = lower + k -1;
		if(k>0 && nextLower<nextUpper) {
			
			min = Math.min(findMinInRange(nums, lower, nextLower), findMinInRange(nums, nextUpper, upper));
		} else {
			for(int i =lower-1;i<upper;i++) {
				min = Math.min(min, nums[i]);
			}
		}
		
		return min;
	}

	private static int closestPowerOfTwo(int num) {
		int i = 0;
		int power = 0;
		int closest = 0;
		while(true) {
			power = (int) Math.pow(2, i);
			if(power>num) {
				break;
			}
			i++;
			closest = power;
		}
		return closest;
	}
}
