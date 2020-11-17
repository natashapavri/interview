package google;

import java.util.HashMap;
import java.util.Map;

public class PointsOnLine {

	public static void main(String[] args) {
		int[][] points = { { 1,1},{2,2},{3,3} };

		Map<Integer, Integer> pointSlope = new HashMap<>();

		int max = Integer.MIN_VALUE;
		int verticals = 0;
		for (int i = 0; i < points.length - 1; i++) {
			int curMax = Integer.MIN_VALUE;
			verticals = 0;
			for (int j = i + 1; j < points.length; j++) {

				if (points[i][0] == points[j][0] && points[i][1] != points[j][1]) {
					verticals++;
				} else {
					int slopeY = (points[i][1] - points[j][1]);
					int slopeX = (points[i][0] - points[j][0]);
					int gcd = gcd(slopeX, slopeY);
					slopeX = slopeX / gcd;
					slopeY = slopeY / gcd;
					int ratio = 0;
					if (slopeX != 0) {
						ratio = slopeY / slopeX;
					}
					pointSlope.putIfAbsent(ratio, 0);
					pointSlope.put(ratio, pointSlope.get(ratio) + 1);

					curMax = Math.max(curMax, pointSlope.get(ratio));
				}
				curMax = Math.max(curMax, verticals);
			}

			max = Math.max(max, curMax);
			
			pointSlope.clear();
		}

		
		System.out.println(max);
	}

	private static int gcd(int slopeX, int slopeY) {
		if (slopeX == 1 || slopeY == 1)
			return 1;

		int max_gcd = Integer.MIN_VALUE;
		for (int i = 1; i < slopeX && i < slopeY; i++) {
			if (slopeX % i == 0 && slopeY % i == 0) {
				int gcd = i;
				if (max_gcd < gcd) {
					max_gcd = gcd;
				}
			}
		}

		return max_gcd;
	}
}
