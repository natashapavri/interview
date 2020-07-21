
public class LongestPalindrome {

	public String longestPal(String s) {
		String reverse  = "";
		char[] chars = s.toCharArray();
		for(int i = chars.length - 1; i>=0; i--) {
			reverse+=(chars[i]);
		}
		System.out.println(reverse);
		if(s.equals(reverse)) return s;
		if(s.length() > 0) {
			s = s.substring(1, s.length() -1);
		}
		return longestPal(s);
	}
	
	public static void main(String[] args) {
		String s = "forgeeksskeegfor";
		LongestPalindrome obj = new LongestPalindrome();
		String pal = obj.longestPal(s);
		System.out.println("Palindrome: " + pal);
	}
}
