package google;

public class MaxWater {

	// time complexity = O(n)
	// space complexity = O(1)
	public static void main(String[] args) {
		int[] heights = { 2, 1, 5, 6, 2, 3 };

		int max = Integer.MIN_VALUE;
		int l = 0, r = heights.length - 1;
		while(l < r) {
			int height = Math.min(heights[l], heights[r]);
			int base = r - l;
			int area = height * base;
			max = Math.max(max, area);
			
			if(heights[l] > heights[r]) {
				l++;
			} else {
				r--;
			}
		}

		System.out.println(max);
	}

}
