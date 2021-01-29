package google;

import java.util.Stack;

public class LongestValidParenthesis {

	public static void main(String[] args) {
		String input = "(()";
		
		if("".equals(input) || input == null) {
			return;
		}
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(-1);
		int maxLength = Integer.MIN_VALUE;
		
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(c == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if(stack.isEmpty()) {
					stack.push(i);
				} else {
					maxLength = Math.max(maxLength, (i-stack.peek()));
				}
			}
		}
		
		
		System.out.println(maxLength);
	}
}
