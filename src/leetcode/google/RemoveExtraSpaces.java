package leetcode.google;

public class RemoveExtraSpaces {

	public static void main(String[] args) {
		String input = "    word1     word2     word3     ";
		String output = distributeSpaces(input);
		System.out.println(output);
	}

	private static String distributeSpaces(String input) {
		
		int spaces = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == ' ') {
				spaces++;
			}
		}
		
		input = input.trim();
		input = input.replaceAll("\\s+", " ");
		int wordCount = input.split(" ").length;
		
		int steps = spaces / wordCount;
		int extra = spaces % wordCount;
		
		String spaceStr = "";
		for(int i = 0; i < steps; i++) {
			spaceStr = spaceStr.concat(" ");
		}
		
		input = input.replaceAll(" ", spaceStr);
		String extraStr = "";
		for(int i = 0; i < extra; i++) {
			extraStr = extraStr.concat(" ");
		}
		input = input.replaceFirst(spaceStr, spaceStr.concat(extraStr));
		
		return input;
	}
}
