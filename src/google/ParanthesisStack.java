package google;

import java.util.Stack;

public class ParanthesisStack {

	public static void main(String[] args) {
		String str = "(()())";
		
		Stack<Character> stack = new Stack<>();
		
		for(char c : str.toCharArray()) {
			if(c == '(') {
				stack.push(c);
			} else {
				stack.pop();
			}
		}
		
		if(stack.isEmpty()) System.out.println(1);
		else System.out.println(0);
	}
}
