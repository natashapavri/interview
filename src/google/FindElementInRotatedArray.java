package google;

public class FindElementInRotatedArray {

	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
		int target = 0;
		
		int left = 0;
		int right = nums.length - 1;
		int result = -1;
		
		while(right>=left) {
			int mid = (left + right) / 2;
			if(nums[mid] == target) {
				result = mid;
				break;
			}
			// left sorted array
			else if(nums[left] <= nums[mid]) {
				if(nums[left] <= target && nums[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			// right sorted array
			else if(nums[right] >= nums[mid]) {
				if(nums[mid] < target && nums[right] >= target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		
		System.out.println(result);
	}
	
}

