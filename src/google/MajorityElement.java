package google;

public class MajorityElement {

	// Moore's voting algorithm

	public static void main(String[] args) {
		int[] nums = { 2, 3, 4, 4, 2, 7, 2 };
		
		int candidate = findCandidate(nums);
		
		if(isCandidateCorrect(candidate, nums)) {
			System.out.println(candidate);
		} else {
			System.out.println("No candidate");
		}
	}

	private static boolean isCandidateCorrect(int candidate, int[] nums) {
		
		int count = 0;
		for(int  i =0;i<nums.length;i++) {
			if(nums[i] == candidate) {
				count++;
				
				if(count >= nums.length/2) {
					return true;
				}
			}
		}
		
		return false;
	}

	private static int findCandidate(int[] nums) {
		
		int candidate = nums[0];
		int count = 1;
		for(int i = 1; i<nums.length;i++) {
			if(nums[i] == candidate) {
				count++;
			} else {
				count--;
			}
			
			if(count == 0) {
				candidate = nums[i];
				count = 1;
			}
		}
		
		return candidate;
		
	}
}
