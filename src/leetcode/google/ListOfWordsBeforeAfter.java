package leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfWordsBeforeAfter {

	public static void main(String[] args) {
		String word = "leetcode";
		int n = 3;
		String[] words = { "apple", "bat", "cat", "fish", "leetcode", "leetcode", "snip", "snap", "hat", "dog" };
		List<String[]> output = new ArrayList<>();
		
		for(int  i = 0; i < words.length; i++) {
			if(words[i].equals(word)) {
				String[] result = Arrays.copyOfRange(words, Math.max(0,  (i - n)), Math.min(words.length, (i + n + 1)));
				output.add(result);
			}
		}
		
		for(String[] s : output) {
			for(String str : s) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
}
