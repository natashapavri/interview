package leetcode.google;

public class PalindromeCommonCut {

	public static void main(String[] args) {
		String a = "abcd";
		String b = "cdba";
		
		boolean result = checkPalindrome(a, b) || checkPalindrome(b, a);
		System.out.println(result);
	}

	private static boolean checkPalindrome(String a, String b) {
		int i = 0;
		int j = a.length() - 1;
		
		while(i < a.length() && j >= 0) {
			if(a.charAt(i) == b.charAt(j)) {
				i++;
				j--;
			}
			else {
				break;
			}
		}
		
		if(i >= j) {
			return true;
		}
		
		/**
		 * a = abcd and b = cdab
		 * a = abcd and b = cddc
		 * 
		 *  this last condition means we can cut at the end of the one of the strings so that the result is a palindrome 
		 */
		return isPalindrome(a.substring(i, j+1)) || isPalindrome(b.substring(i,  j+1));
	}

	private static boolean isPalindrome(String a) {
		int start = 0;
		int end = a.length() - 1;
		while(end > start) {
			if(a.charAt(start) != a.charAt(end)) {
				return false;
			}
		}
		return true;
	}
}
