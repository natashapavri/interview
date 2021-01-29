package google;

public class WindowString {

	public static void main(String[] args) {
		String str = "ADOBECODEBANC";
		String pattern = "ABC";

		String text = findWindowString(str, pattern);

		if (text == null) {
			System.out.println("Pattern not possible");
		} else {
			System.out.println(text);
		}
	}

	private static String findWindowString(String str, String pattern) {

		if (str.length() < pattern.length())
			return null;

		int[] hash_pattern = new int[256];
		int[] hash_str = new int[256];

		for (char c : pattern.toCharArray()) {
			hash_pattern[c]++;
		}

		int count = 0;
		int start = 0;
		int win_len = Integer.MAX_VALUE;
		int start_index = -1;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			hash_str[c]++;
			
			// finding characters of pattern & adding to count till we need the
			// desired frequency
			if (hash_pattern[c] != 0 && hash_str[c] <= hash_pattern[c]) {
				count++;
			}

			// matched the pattern. Hence optimize
			// 1. Remove all characters not in pattern
			// 2. Remove additional matching characters more than what the
			// pattern needs
			if (count == pattern.length()) {
				while (hash_pattern[str.charAt(start)] == 0
						|| hash_str[str.charAt(start)] > hash_pattern[str.charAt(start)]) {
					
					if(hash_str[str.charAt(start)] > hash_pattern[str.charAt(start)])
						hash_str[str.charAt(start)]--;
					start++;
				}
				int len_win = i - start; 
				if(win_len > len_win) {
					win_len = len_win;
					start_index = start;
				}
			}
		}
		
		if(start_index == -1) {
			return null;
		}
		// start + length of window = end
		return str.substring(start_index, start_index + win_len + 1);
	}
}
