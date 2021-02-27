package google;

import java.util.HashSet;
import java.util.Set;

public class PalindromeSubsets {

	// subsets is important. this means we cannot permute the characters anyways
	// we want. It has to be in the order in the string given
	public static void main(String[] args) {
		String str = "baaba";

		Set<String> results = new HashSet<>();

		subsetHelper(str.toCharArray(), results, new StringBuilder(), 0);

		for (String s : results) {
			System.out.println(s);
		}
	}

	private static void subsetHelper(char[] arr, Set<String> results, StringBuilder resultList, int start) {
		StringBuilder sb = new StringBuilder(resultList);
		if (sb.reverse().toString().equals(resultList.toString()) && !sb.toString().equals(""))
			results.add(new StringBuilder(resultList).toString());

		for (int i = start; i < arr.length; i++) {
			resultList.append(arr[i]);
			subsetHelper(arr, results, resultList, i + 1);
			resultList = resultList.deleteCharAt(resultList.length() - 1);
		}
	}
}
