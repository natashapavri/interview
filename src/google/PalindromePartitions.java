package google;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitions {

	public static void main(String[] args) {
		String str = "aba";
		List<List<String>> results = new ArrayList<>();
		findSubsets(str, results, new ArrayList<>(), 0);
		
		for(List<String> rs : results) {
			for(String s : rs) {
				System.out.print(s + ", ");
			}
			System.out.println();
		}
	}

	private static void findSubsets(String str, List<List<String>> results, List<String> result, int start) {

		if(start >= str.length()) {
			results.add(new ArrayList<>(result));
		}
		
		for(int i = start; i < str.length(); i++) {
			if(isPalindrome(str.substring(start, i+1))) {
				result.add(str.substring(start, i+1));
				findSubsets(str, results, result, i+1);
				result.remove(result.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String str) {
		for(int i = 0; i < str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
