package string;

public class PalindromeCheck {

	public static void main(String[] args) {
		String str = "manam";
		
		if(str == null || str.length() == 0) throw new IllegalArgumentException();
		System.out.println(isPalindrome(str));
	}

	private static boolean isPalindrome(String str) {
		char[] arr = str.toCharArray();
		for(int i =0;i<arr.length /2 ;i++) {
			if(arr[i] != arr[arr.length -1 -i]) return false;
		}
		return true;
	}
}
