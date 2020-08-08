package google;

public class InsertSortList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode five = new ListNode(5);
		head.setNext(five);
		ListNode four = new ListNode(4);
		five.setNext(four);
		ListNode three = new ListNode(3);
		four.setNext(three);

		head = sortList(head);

		while (head != null) {
			System.out.print(head.getValue() + ", ");
			head = head.getNext();
		}
	}

	private static ListNode sorted = null;

	private static ListNode sortList(ListNode head) {
		if (head == null || head.getNext() == null)
			return head;

		ListNode current = head;
		while (current != null) {
			ListNode next = current.getNext();
			insertSort(current);
			current = next;
		}

		return sorted;
	}

	private static void insertSort(ListNode node) {

		if (sorted == null || sorted.getValue() > node.getValue()) {
			node.setNext(sorted);
			sorted = node;
		} else {
			ListNode current = sorted;
			while (current.getNext() != null && current.getNext().getValue() <= node.getValue()) {
				current = current.getNext();
			}
			node.setNext(current.getNext());
			current.setNext(node);
		}
	}
}
