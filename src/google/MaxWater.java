package google;

public class MaxWater {

	public static void main(String[] args) {
		int[] heights = { 2, 1, 5, 6, 2, 3 };

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < heights.length; i++) {
			for (int j = i + 1; j < heights.length; j++) {
				int height = Math.min(heights[j], heights[i]);
				int base = j - i;
				int area = base * height;
				max = Math.max(max, area);
			}

		}

		System.out.println(max);
	}

}
