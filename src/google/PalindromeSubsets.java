package google;

import java.util.ArrayList;
import java.util.List;

public class PalindromeSubsets {

	public static void main(String[] args) {
		String str = "aab";

		List<StringBuilder> results = new ArrayList<>();

		subsetHelper(str.toCharArray(), results, new StringBuilder(), 0);

		for (StringBuilder s : results) {
			System.out.println(s.toString());
		}
	}

	private static void subsetHelper(char[] arr, List<StringBuilder> results, StringBuilder resultList, int start) {
		StringBuilder sb = new StringBuilder(resultList);
		if (sb.reverse().toString().equals(resultList.toString()) && !sb.toString().equals(""))
			results.add(new StringBuilder(resultList));

		for (int i = start; i < arr.length; i++) {
			resultList.append(arr[i]);
			subsetHelper(arr, results, resultList, i + 1);
			resultList = resultList.delete(resultList.length() - 1, resultList.length());
		}
	}
}
