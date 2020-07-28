package stack;
import java.util.Stack;

public class MaxStack extends Stack<Integer> {
	private static final long serialVersionUID = 1L;
	Stack<Integer> max;

	public MaxStack() {
		super();
		max = new Stack<>();
	}

	@Override
	public Integer push(Integer item) {
		super.push(item);
		if (max.isEmpty())
			max.push(item);
		else {
			if(item > max.peek()) {
				max.push(item);
			}
		}
		return item;
	}
	
	@Override
	public synchronized Integer pop() {
		int item = super.pop();
		if(!max.isEmpty()) {
			if(max.peek() == item) {
				max.pop();
			}
		}
		return item;
		
	}
	
	public Integer max() {
		if(max.isEmpty()) return null;
		return max.peek();
	}

	public static void main(String[] args) {
		MaxStack stack = new MaxStack();
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(6);
		
		System.out.println(stack.max());
		stack.pop();
		System.out.println(stack.max());
	}
}
