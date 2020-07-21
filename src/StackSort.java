import java.util.Stack;

public class StackSort {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(2);
		stack.push(4);

		Stack<Integer> result = new Stack<>();

		while (!stack.isEmpty()) {
			int num = stack.pop();
			if (result.isEmpty())
				result.push(num);
			else {
				while (!result.isEmpty() && num > result.peek()) {
					int s = result.pop();
					stack.push(s);
				}

				result.push(num);
			}
		}

		while (!result.isEmpty()) {
			System.out.print(result.pop() + ", ");
		}
	}
}
