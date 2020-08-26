package google;

public class StretchyWord {

	public static void main(String[] args) {
		
		String[] words = {"heeelloooworld"};
		String S = "heeellooo";
		
		if(S == null || S.equals("") || words == null || words.length == 0) System.out.println(0);
		 
		 
		int count = expressiveWords(S, words);
		System.out.println(count);
	}

	private static int expressiveWords(String S, String[] words) {

		int count = 0;

		for (int i = 0; i < words.length; i++) {
			boolean isStretchy = isStretchy(words[i], S);
			if (isStretchy)
				count++;
		}

		return count;
	}

	private static boolean isStretchy(String word, String search) {

		int i = 0, j = 0;

		while (i < word.length() && j < search.length()) {
			char w = word.charAt(i);
			char s = search.charAt(j);

			if (w != s) {
				return false;
			}

			int freqW = 0;
			int freqS = 0;

			while (i < word.length() && word.charAt(i) == w) {
				freqW++;
				i++;
			}

			while (j < search.length() && search.charAt(j) == s) {
				freqS++;
				j++;
			}

			if (freqS < 3 && freqW != freqS) {
				return false;
			}

			if (freqS >= 3 && freqW > freqS) {
				return false;
			}

		}
		
		if(j != search.length() || i != word.length()) {
			return false;
		}

		return true;
	}

}
