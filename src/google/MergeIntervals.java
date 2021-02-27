package google;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		int[][] pairs = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] merge = { 4, 9 };

		List<int[]> overlaps = new ArrayList<int[]>();

		for (int[] pair : pairs) {
			int left = pair[0];
			int right = pair[1];
			int mergeLeft = merge[0];
			int mergeRight = merge[1];

			if (mergeLeft < right && mergeRight > left) {
				overlaps.add(pair);
			}
		}

		overlaps.add(merge);

		int left = Integer.MAX_VALUE;
		int right = Integer.MIN_VALUE;
		for (int[] overlap : overlaps) {
			if (left > overlap[0]) {
				left = overlap[0];
			}
			if (right < overlap[1]) {
				right = overlap[1];
			}
		}

		System.out.println(left + ", " + right);

	}
}
