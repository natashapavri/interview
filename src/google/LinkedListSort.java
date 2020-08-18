package google;

public class LinkedListSort {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode five = new ListNode(5);
		head.setNext(five);
		ListNode four = new ListNode(4);
		five.setNext(four);
		ListNode three = new ListNode(3);
		four.setNext(three);

		head = sortList(head);

		ListNode start = head;
		while (start != null) {
			System.out.println(start.getValue());
			start = start.getNext();
		}
	}

	private static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode m = getMiddleNode(head);
		// start of list 2
		ListNode mNext = m.getNext();
		// end of list 1
		m.setNext(null);

		ListNode left = sortList(head);
		ListNode right = sortList(mNext);

		ListNode merge = mergeList(left, right);

		return merge;
	}

	private static ListNode mergeList(ListNode left, ListNode right) {

		ListNode result = null;
		if (left == null)
			return right;
		if (right == null)
			return left;

		if (left.getValue() < right.getValue()) {
			result = left;
			result.setNext(mergeList(left.getNext(), right));
		} else {
			result = right;
			result.setNext(mergeList(left, right.getNext()));
		}

		return result;
	}

	private static ListNode getMiddleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast.getNext().getNext() != null && slow.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		return slow;
	}
}

