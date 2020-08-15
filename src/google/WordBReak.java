package google;

public class WordBReak {

	public static void main(String[] args) {
		String a = "catsandog";
		String[] b = { "cats", "and", "dog" };


		Integer searchIndex = 0; 
		searchIndex = wordSearch(a, b, searchIndex);

		if (searchIndex == a.length())
			System.out.println("true");
		else
			System.out.println("false");
	}

	private static Integer wordSearch(String a, String[] b, Integer searchIndex) {
		for (String word : b) {
			if (a.startsWith(word, searchIndex)) {
				searchIndex = searchIndex + word.length();
				if(searchIndex <= a.length())
					return wordSearch(a, b, searchIndex);
				else
					break;
			} 
		}
		
		return searchIndex;
	}
}
