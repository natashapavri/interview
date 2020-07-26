import java.util.ArrayList;
import java.util.List;

public class SubArrayOfLengthAndSum {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 3;
		int magic_matrix = k * ((k * k) + 1) / 2;

		List<int[]> result = new ArrayList<>();
		
		

		for (int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				if (nums[i] + nums[left] + nums[right] == magic_matrix) {
					result.add(new int[] { nums[i], nums[left], nums[right] });
					left++;
					right--;
				} else if (nums[i] + nums[left] + nums[right] < magic_matrix) {
					left++;
				} else {
					right--;
				}
			}
		}

		for (int[] r : result) {
			for (int i = 0; i < r.length; i++) {
				System.out.print(r[i] + ", ");
			}
			System.out.println();
		}
	}
}
