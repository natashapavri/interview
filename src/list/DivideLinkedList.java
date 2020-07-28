package list;

public class DivideLinkedList {

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		
		one.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(five);
		
		ListNode [] lists = divide(one);
		
		ListNode first = lists[0];
		ListNode second = lists[1];
		
		while(first != null) {
			System.out.print(first.getValue() + ", ");
			first = first.getNext();
		}
		System.out.println();
		while(second != null) {
			System.out.print(second.getValue() + ", ");
			second = second.getNext();
		}
	}

	private static ListNode[] divide(ListNode one) {
		ListNode current = one;
		ListNode runner = one;
		while(runner.getNext() != null) {
			runner = runner.getNext().getNext();
			if(runner == null) break;
			current = current.getNext();
		}
		if(current != null && current.getNext() != null) {
			ListNode second = current.getNext();
			current.setNext(null);
			ListNode first = one; 
			return new ListNode[] {first, second};
		}
		return null;
	}
	
	
	
	
}
