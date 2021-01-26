package google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxDistanceArray {

	public static void main(String[] args) {
		int[] arr = { 3, 5, 4, 2 };
		Map<Integer, Integer> index = new HashMap<>();
		for(int i = 0 ; i < arr.length; i++) {
			index.put(arr[i], i);
		}
		Arrays.sort(arr);
		int output = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			int idx = index.get(arr[i]);
			min = Math.min(min, idx);
			output = Math.max(output, idx - min);
		}
		
		System.out.println(output);
	}
}
