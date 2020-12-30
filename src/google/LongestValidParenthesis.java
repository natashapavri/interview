package google;

public class LongestValidParenthesis {

	public static void main(String[] args) {
		String input = ")()())";
		
		int openCount = 0, closeCount = 0;
		
		for(char c : input.toCharArray()) {
			if(c == '(') openCount++;
			else closeCount++;
		}
		
		if(openCount == closeCount) {
			System.out.println(2 * openCount);
		} else if (openCount > closeCount) {
			System.out.println(2 * closeCount);
		} else {
			System.out.println(2 * openCount);
		}
	}
}
