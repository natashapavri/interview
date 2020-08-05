package google;

public class PeakElement {

	public static void main(String[] args) {
		int[] nums = {5, 17, 100, 11};
		
		int peak = findPeak(nums);
		
		System.out.println(peak);
	}

	private static int findPeak(int[] nums) {
		int left = 0;
		int right = nums.length;
		while(right > left) {
			int mid = (left + right) / 2;
			if(isPeak(nums, mid)) {
				return nums[mid];
			} else {
				// only one peak element exist so no need to check both ends
				if(nums[mid - 1] > nums[mid + 1]) {
					right = mid - 1;
				} else {
					left = mid  + 1;
				}
			}
		}
		
		return -1;
	}

	private static boolean isPeak(int[] nums, int mid) {
		// checking corner cases
		if(mid == 0) {
			if(nums[mid] > nums[mid  + 1]) {
				return true;
			} else {
				return false;
			}
		}
		// checking corner cases
		else if(mid == nums.length - 1) {
			if(nums[mid] > nums[mid - 1]) {
				return true;
			} else {
				return false;
			}
		}
		else if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
			return true;
		} else {
			return false;
		}
	}
}
