package leetcode.google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {

	public static void main(String[] args) {
		int[] arr1 = { 26, 21, 11, 20, 50, 34, 1, 18 };
		int[] arr2 = { 21, 11, 26, 20 };

		Map<Integer, Integer> positionMap = new HashMap<>();
		for (int i = 0; i < arr2.length; i++) {
			positionMap.put(arr2[i], i);
		}

		CustomComparator comp = new CustomComparator(positionMap);

		Integer[] arr = new Integer[arr1.length];
		int j = 0;
		for (int i : arr1) {
			arr[j++] = i;
		}

		Arrays.sort(arr, comp);

		j = 0;
		for (int i : arr) {
			arr1[j++] = i;
		}

		for (int i : arr1) {
			System.out.print(i + ", ");
		}
	}

}

class CustomComparator implements Comparator<Integer> {

	private Map<Integer, Integer> positionMap;

	public CustomComparator(Map<Integer, Integer> map) {
		positionMap = map;
	}

	@Override
	public int compare(Integer a, Integer b) {
		if (positionMap.containsKey(a) && positionMap.containsKey(b)) {
			return positionMap.get(a).compareTo(positionMap.get(b));
		} else if (positionMap.containsKey(a) && !positionMap.containsKey(b)) {
			return -1;
		} else if (!positionMap.containsKey(a) && positionMap.containsKey(b)) {
			return 1;
		}
		else {
			return a.compareTo(b);
		}
	}
}
