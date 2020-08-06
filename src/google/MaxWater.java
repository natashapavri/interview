package google;

public class MaxWater {

	public static void main(String[] args) {
		int[] heights = { 3, 1, 2, 4, 5 };

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < heights.length; i++) {
			for(int j = i + 1; j<heights.length; j++) {
				int height = Math.min(heights[j], heights[i]);
				int base = Math.abs(i - j);
				int area = base * height;
				max = Math.max(max, area);
			}
			
		}

		System.out.println(max);
	}

}
