package string;

public class LongestSubstring {

	// Substring = characters together and in order
	public static void main(String[] args) {
		String[] texts = { "ABAB", "BABA" };
		String longest = findSubString(texts);
		System.out.println(longest);
	}

	private static String findSubString(String[] texts) {
		String a = texts[0];
		String b = texts[1];
		int[][] cache = new int[a.length()][b.length()];

		int max_len = 0;
		String output = null;
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					if (i == 0 || j == 0) {
						// only one character substring
						cache[i][j] = 1;
					} else {
						// diagonally upwards
						cache[i][j] = cache[i - 1][j - 1] + 1;
					}

					if (cache[i][j] > max_len) {
						max_len = cache[i][j];
						// start + length of window = end
						// thus, end - length = start
						// end = i + 1 and length = cache[i][j]
						output = a.substring(i + 1 - cache[i][j], i + 1);
						System.out.println(output);
					}
				}
			}
		}
		return output;
	}
}
