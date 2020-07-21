
public class ReverseLinkedList {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		head.setNext(two);
		two.setNext(three);
		three.setNext(four);

		head = reverseList(head);

		while (head != null) {
			System.out.print(head.getValue() + ", ");
			head = head.getNext();
		}
	}

	private static ListNode reverseList(ListNode head) {
		ListNode current = head;
		ListNode prev = null;
		ListNode next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
}
