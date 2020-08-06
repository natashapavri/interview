package google;

import java.util.ArrayList;
import java.util.List;

public class JustifiedText {

	public static void main(String[] args) {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		int length = 16;
		
		List<String> lines = getPrettyPrint(words, length);
		
		for(String line : lines) {
			System.out.println(line);
		}
	}

	private static List<String> getPrettyPrint(String[] words, int length) {
		List<String> lines = new ArrayList<String>();
		String line = new String();
		int lineSum = 0;
		int noOfWordsInLine = 0;
		for(String word : words) {
			word = word.concat(" ");
			if((lineSum + word.length()) <= length) {
				noOfWordsInLine++;
				lineSum+=word.length();
				line = line.concat(word);
			} else{
				line = adjustLine(line.trim(), length, noOfWordsInLine);
				lines.add(line);
				line = new String(word);
				noOfWordsInLine = 1;
				lineSum = 0;
				lineSum+=word.length();
			}
		}
		
		if(line != null) {
			line = adjustLine(line, length, noOfWordsInLine);
			lines.add(line);
		}
		return lines;
	}

	private static String adjustLine(String line, int length, int noOfWordsInLine) {
		if(line.length() == length) return line; 
		
		if(line.length() < length) {
			int extraSpaces = length - line.length();
			String[] words = line.split(" ");
			int i = 0;
			while(extraSpaces-- > 0) {
				words[i] = words[i].concat(" ");
				i++;
				if(i == words.length - 1) {
					i = 0;
				}
			}
			line = String.join(" ", words);
		}
		
		return line;
	}
}
