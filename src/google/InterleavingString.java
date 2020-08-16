package google;

public class InterleavingString {

	public static void main(String[] args) {
		String A = "aabcc";
		String B = "dbbca";
		String C = "aadbbbaccc";

		boolean isMatch = isInterleaving(A, B, C);

		System.out.println(isMatch);
	}

	private static boolean isInterleaving(String a, String b, String c) {
		boolean isMatch = false;

		int i = 0, j = 0, k = 0;

		while (i < a.length() || j < b.length() || k < c.length()) {
			boolean isFound = false;
			
			while(i < a.length() && k < c.length() && a.charAt(i) == c.charAt(k)) {
				i++;
				k++;
				isFound = true;
			}
			while(j < b.length() && k < c.length() && b.charAt(j) == c.charAt(k)) {
				j++;
				k++;
				isFound = true;
			}
			if(!isFound) {
				isMatch = false;
				break;
			}
		}
		
		if(i==a.length() && j==b.length() && k==c.length()) {
			isMatch = true;
		}
		

		return isMatch;
	}
}
