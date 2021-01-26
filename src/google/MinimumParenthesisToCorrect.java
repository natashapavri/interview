package google;

import java.util.Stack;

public class MinimumParenthesisToCorrect {

	public static void main(String[] args) {
		String text = "leet(c(od)e";
		String input1 = "(())";
		String input2 = "(())((";
		String input3 = "(((";
		
		int result_text = findParenthesisToAdd(text);
		int result_input1 = findParenthesisToAdd(input1);
		int result_input2 = findParenthesisToAdd(input2);
		int result_input3 = findParenthesisToAdd(input3);
		
		System.out.println(result_text);
		System.out.println(result_input1);
		System.out.println(result_input2);
		System.out.println(result_input3);
		
		if(result_text == 0) System.out.println("Balanced"); else System.out.println("Unbalanced");
		if(result_input1 == 0) System.out.println("Balanced"); else System.out.println("Unbalanced");
		if(result_input2 == 0) System.out.println("Balanced"); else System.out.println("Unbalanced");
		if(result_input3 == 0) System.out.println("Balanced"); else System.out.println("Unbalanced");
	}

	private static int findParenthesisToAdd(String text) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if(c == '(') {
				stack.push(i);
			} else if(c == ')') {
				if(!stack.isEmpty() && text.charAt(stack.peek()) == '(') {
					stack.pop();
				}
				else {
					stack.push(i);
				}
			}
		}
		
		/*StringBuilder sb = new StringBuilder(text);
		while(!stack.isEmpty()) {
			sb.deleteCharAt(stack.pop());
		}
		System.out.println(sb.toString());*/
		return stack.size();
	}
}
