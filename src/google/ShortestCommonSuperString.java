package google;

public class ShortestCommonSuperString {

	public static void main(String[] args) {
		String[] input = { "abcd", "cdef", "fgh", "de" };

		String output = "";

		output = input[0];
		for (int i = 1; i < input.length; i++) {
			String str = input[i];
			for (int j = 0; j < str.length(); j++) {
				String subStr = str.substring(0, j + 1);
				if (!output.contains(subStr)) {
					output = output + str.charAt(j);
				}
			}
		}

		System.out.println(output);
	}
}
