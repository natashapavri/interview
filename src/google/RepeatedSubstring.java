package google;

public class RepeatedSubstring {

	public static void main(String[] args) {
		String input = "abcab";

		String repeatString = findRepeatString(input);

		System.out.println(repeatString);
	}

	private static String findRepeatString(String input) {
		String repeat = "";
		for (int i = 0; i < input.length() / 2; i++) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				repeat = repeat + input.charAt(i);
			}
			else {
				break;
			}
		}
		
		return repeat;
	}

}
