package google;

public class BSTMissingElement {

	
	public static void main(String[] args) {
		int[] nums = {1,3,4,6,7,9,10};
		int k = 3;
		int n = findMissingElement(nums, k);
		System.out.println(n);
		
		int[] num = {1,2,3,4,6,7,8,9,10};
		n = findMissingElement(num);
		System.out.println(n);
	}

	private static int findMissingElement(int[] num) {
		int l = 0;
		int r = num.length - 1;
		int mid=0;
		
		while(l < (r - 1)) {
			mid = l + (r - l)/2;
			if(num[l] - l != num[mid] - mid) {
				r = mid;
			} else if(num[r] - r != num[mid] - mid) {
				l = mid;
			}
		}
		
		return num[mid] + 1;
	}

	private static int findMissingElement(int[] nums, int i) {
		int l = 0;
		int r = nums.length - 1;
		while(l < r - 1) {
			int mid = l + (r - l) / 2;
			int missing = (nums[mid] - nums[l]) - (mid - l);
			if(missing >=i) {
				r = mid;
			} else {
				l = mid;
				i-=missing;
			}
		}
		
		int missing = nums[r] - nums[l] - 1;
		if(missing>=i) return nums[l] + i;
		else return nums[r] + i - missing;
	}
	
	
	
}
