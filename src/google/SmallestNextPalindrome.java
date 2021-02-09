package google;

public class SmallestNextPalindrome {

	public static void main(String[] args) {
		String str1 = "23545";
		String str2 = "1253";
		String str3 = "999";
		
		String left = getLeft(str1);
		String nextPalindrome = getNextPalindrome(str1, left);
		
		System.out.println(nextPalindrome);
		
		left = getLeft(str2);
		nextPalindrome = getNextPalindrome(str2, left);
		
		System.out.println(nextPalindrome);
		
		left = getLeft(str3);
		nextPalindrome = getNextPalindrome(str3, left);
		
		System.out.println(nextPalindrome);
	}

	private static String getNextPalindrome(String str, String left) {
		// replace the left on the right
		// increase left by 1 and replace left on right
		// decrease left by 1 and replace left on right
		long strNum = Long.parseLong(str);
		long leftNum = Long.parseLong(left);
		
		String nextPalindrome = null;
		long nextPalindromeNum = 0;
		
		// replace the left on the right
		nextPalindrome = left.concat(reverse(left, str.length()%2 == 0));
		nextPalindromeNum = Long.parseLong(nextPalindrome);
		if(nextPalindromeNum > strNum) {
			return nextPalindrome;
		}
		// increase left by 1 and replace left on right
		String leftIncrease = String.valueOf(leftNum+1);
		nextPalindrome = leftIncrease.concat(reverse(leftIncrease, str.length()%2 == 0));
		nextPalindromeNum = Long.parseLong(nextPalindrome);
		if(nextPalindromeNum > strNum) {
			return nextPalindrome;
		}
		// decrease left by 1 and replace left on right
		String leftDecrease = String.valueOf(leftNum-1);
		nextPalindrome = leftDecrease.concat(reverse(leftDecrease, str.length()%2 == 0));
		nextPalindromeNum = Long.parseLong(nextPalindrome);
		if(nextPalindromeNum > strNum) {
			return nextPalindrome;
		}
		return nextPalindrome;
	}

	private static String reverse(String str, boolean b) {
		if(!b) {
			str = str.substring(0, str.length() - 1);
		}
		
		char[] strArr = str.toCharArray();
		int i = 0, j=strArr.length -1;
		while(j>i) {
			char t = strArr[i];
			strArr[i] = strArr[j];
			strArr[j] = t;
			i++;
			j--;
		}
		return new String(strArr);
	}

	private static String getLeft(String str) {
		if(str.length() % 2 == 0) {
			return str.substring(0, str.length()/2);
		} else {
			return str.substring(0, (str.length()/2 +1));
		}
	}
}
