package list;

public class SwapListPairs {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		head.setNext(two);
		two.setNext(three);
		three.setNext(four);

		head = swapNodes(head);
		
		while(head != null) {
			System.out.println(head.getValue() + ", ");
			head = head.getNext();
		}
	}

	private static ListNode swapNodes(ListNode head) {
		if(head == null || head.getNext() == null) return head;
		ListNode remaining = head.getNext().getNext();
		ListNode newHead = head.getNext();
		newHead.setNext(head);
		head.setNext(swapNodes(remaining));
		return newHead;
	}

}

class ListNode {
	private int value;
	ListNode next;

	public ListNode(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode [value=" + value + ", next=" + next + "]";
	}
	
	

}
