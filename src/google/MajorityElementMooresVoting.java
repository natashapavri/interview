package google;

public class MajorityElementMooresVoting {

	// Moore's voting algorithm
	//Time complexity = O(n)
	//Space complexity = O(1)

	public static void main(String[] args) {
		int[] nums = { 2, 3, 4, 4, 2, 7, 2 };
		
		int[] candidates = findCandidate(nums);
		
		int result = isCandidateCorrect(candidates, nums);
		
		System.out.println(result);
	}

	private static int isCandidateCorrect(int[] candidates, int[] nums) {
		
		int candidate1 = candidates[0];
		int candidate2 = candidates[1];
		
		int count1 = 0, count2 = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == candidate1) {
				count1++;
			} else if(nums[i] == candidate2) {
				count2++;
			}
			if(count1 >= Math.floor(nums.length/2)) {
				return candidate1;
			} 
			else if(count2 >= Math.floor(nums.length/2)) {
				return candidate2;
			}
		}
		
		return -1;
	}

	private static int[] findCandidate(int[] nums) {
		
		int candidate1 = -1;
		int candidate2 = -1;
		int count1 = 0, count2 = 0;
		for(int i = 0; i<nums.length;i++) {
			if(count1 == 0) {
				candidate1 = nums[i];
				count1++;
			} 
			if(count2 == 0) {
				candidate2 = nums[i];
				count2++;
			}
			if(nums[i] == candidate1) {
				count1++;
			} else if(nums[i] == candidate2){
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		
		int[] result = new int[2];
		result[0] = candidate1;
		result[1] = candidate2;
		return result;
	}
}
