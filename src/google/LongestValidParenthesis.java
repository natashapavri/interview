package google;

public class LongestValidParenthesis {

	public static void main(String[] args) {
		String input = "))()()";
		
		int openCount = 0, closeCount = 0;
		
		for(char c : input.toCharArray()) {
			if(c == '(') openCount++;
			else closeCount--;
		}
		
		System.out.println(Math.abs(Math.abs(openCount) - Math.abs(closeCount)));
	}
}
