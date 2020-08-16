package google;

public class RegExMatch {

	public static void main(String[] args) {
		String input = "aab";
		String pattern = "c*a*b";

		boolean isMatch = isMatch(input, pattern, 0, 0);

		System.out.println(isMatch);
	}

	private static boolean isMatch(String input, String pattern, int i, int j) {
		if (input.equals(pattern))
			return true;

		if(!pattern.contains(".") && !pattern.contains("*")) {
			if(!input.equals(pattern))
				return false;
		}
		
		boolean isMatch = false;
		while (i < input.length() && j < pattern.length()) {
			if (input.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
				isMatch = true;
			}

			else if (pattern.charAt(j) == '.' && Character.isLetter(input.charAt(i))) {
				i++;
				j++;
				isMatch = true;
			} else if (pattern.charAt(j) == '*' && j == pattern.length() - 1) {
				i++;
				j++;
				isMatch = true;
			} else if (pattern.charAt(j) == '*' && j < pattern.length() - 1) {
				while (input.charAt(i) != pattern.charAt(j + 1) && Character.isLetter(input.charAt(i))) {
					i++;
				}
				j++;
			}
			else if(Character.isLetter(input.charAt(i)) && Character.isLetter(pattern.charAt(j)) && input.charAt(i) != pattern.charAt(j)) {
				i++;
				j++;
				isMatch = false;
			}
		}

		return isMatch;
	}
}
