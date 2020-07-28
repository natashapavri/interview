package arrays;
import java.util.LinkedList;

public class AddOneArrays {

	public static void main(String[] args) {
		NumberNode number = new NumberNode(9);
		number.setNext(new NumberNode(9));
		number.getNext().setNext(new NumberNode(9));
		number.getNext().getNext().setNext(new NumberNode(9));
		
		NumberNode add = new NumberNode(1);
		
		LinkedList<Integer> result = new LinkedList<>();
		int carry = 0;
		
		if(number == null) throw new IllegalArgumentException();
		
		addNumbers(number, add, result, carry);
		
		for(int i = (result.size() - 1); i>=0; i--) {
			System.out.print(result.get(i) + ", ");
		}
	}

	private static void addNumbers(NumberNode number, NumberNode add, LinkedList<Integer> result,
			int carry) {
		
		int sum = number.getData() + add.getData();
		carry = (sum >= 10) ? 1 : 0;
		sum = sum % 10;
		result.add(sum);
		if(number.getNext() != null) {
			addNumbers(number.getNext(), add, result, carry);
		} else {
			if(carry == 1) {
				result.add(carry);
			}
		}
	}
	
	
}

class NumberNode {
	private int data;
	private NumberNode next;
	
	public NumberNode getNext() {
		return next;
	}

	public void setNext(NumberNode next) {
		this.next = next;
	}

	public NumberNode(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}


