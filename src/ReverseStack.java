import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 11; i > 0; i--) {
			stack.push(i);
		}

		System.out.println(stack.size());

		for (int i = 0; i < stack.size() / 2; i++) {
			int a = stack.get(i);
			int b = stack.get(stack.size() - 1 - i);
			int t = a;
			a = b;
			b = t;
			stack.set(i, a);
			stack.set(stack.size() - 1 - i, b);

		}

		for (int i = 0; i < stack.size(); i++) {
			System.out.print(stack.get(i) + ", ");
		}
	}
}
