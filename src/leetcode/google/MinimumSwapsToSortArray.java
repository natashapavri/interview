package leetcode.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsToSortArray {
	
	//Time complexity = O(nlogn)
	//Space complexity = O(n)
	public static void main(String[] args) {
		int[] arr = { 1, 4, 3, 2 };
		int[] temp = Arrays.copyOfRange(arr, 0, arr.length);
		Arrays.sort(temp);
		// this will make it single lookup to find the index we need to swap data with
		Map<Integer, Integer> tPos = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			tPos.put(arr[i], i);
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != temp[i]) {
				int indexToSwapWith = tPos.get(temp[i]);
				int t = arr[i];
				arr[i] = arr[indexToSwapWith];
				arr[indexToSwapWith] = t;
				tPos.put(arr[indexToSwapWith], indexToSwapWith);
				tPos.put(arr[i], i);
				count++;
			}
		}

		System.out.println(count);
	}
}
