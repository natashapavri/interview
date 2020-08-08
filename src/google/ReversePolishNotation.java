package google;

import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {
		String[] expr = { "4", "13", "5", "/", "+" };

		Stack<Integer> operation = new Stack<>();

		for (String c : expr) {
			if (isDigit(c)) {
				int num = Integer.parseInt(c);
				operation.push(num);
			} else {
				String op = c;
				int right = operation.pop();
				int left = operation.pop();

				switch (op) {
				case "+": {
					int sum = left + right;
					operation.push(sum);
					break;
				}
				case "-": {
					int diff = left - right;
					operation.push(diff);
				}
				case "*": {
					int product = left * right;
					operation.push(product);
					break;
				}
				case "/": {
					int div = left / right;
					operation.push(div);
					break;
				}
				default: {
					throw new IllegalArgumentException();
				}
				}
			}
		}
		
		System.out.println(operation.pop());
	}

	private static boolean isDigit(String c) {
		try {
			Integer.parseInt(c);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
