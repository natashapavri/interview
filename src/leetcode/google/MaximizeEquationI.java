package leetcode.google;

public class MaximizeEquationI {

	/**
	 * I and J are two points. J is the current point and I is the old point.
	 * maximize p_i + p_j + |x_i - x_j|
	 * Thus, maximize p_i + p_j + x_j - x_i
	 * Thus, maximize p_j + x_j + (p_i - x_i)
	 */
	public static void main(String[] args) {
		int[] points = {0, 3, 6};
		int[] values = {-5, 4, 7};
		
		int max = points[0] - values[0];
		int ans = Integer.MIN_VALUE;
		for(int i = 1; i < points.length; i++) {
			int value = points[i] + values[i] + max;
			ans = Math.max(ans, value);
			max = Math.max(max, points[i] - values[i]);
		}
		
		System.out.println(ans);
	}
}
