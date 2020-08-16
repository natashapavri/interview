package google;

public class LongestValidParenthesis {

	public static void main(String[] args) {
		String input = ")()())";
		
		int count = 0;
		int length = input.length();
		
		for(char c : input.toCharArray()) {
			if(c == '(') count++;
			else count--;
		}
		
		System.out.println(length - Math.abs(count));
	}
}
