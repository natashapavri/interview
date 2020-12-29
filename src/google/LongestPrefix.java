package google;

public class LongestPrefix {

	public static void main(String[] args) {
		String[] words = { "abab", "ab", "abcd" };
		String smallestWord = findSmallestWord(words);
		String prefix = findLongestPrefix(words, smallestWord);
		System.out.println(prefix);
	}

	private static String findLongestPrefix(String[] words, String smallestWord) {
		boolean contained = true;
		for (String word : words) {
			if (!word.startsWith(smallestWord)) {
				contained = false;
				break;
			}
		}
		if (contained) {
			return smallestWord;
		} else {
			smallestWord = smallestWord.substring(0, smallestWord.length() - 1);
			return findLongestPrefix(words, smallestWord);
		}
	}

	private static String findSmallestWord(String[] words) {
		int minLength = Integer.MAX_VALUE;
		String wordFound = null;

		for (String word : words) {
			if (minLength > word.length()) {
				wordFound = word;
				minLength = word.length();
			}
		}

		return wordFound;
	}
}
