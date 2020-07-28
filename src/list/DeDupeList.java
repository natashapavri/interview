package list;
import java.util.HashSet;
import java.util.Set;

public class DeDupeList {

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode twotwo = new ListNode(2);
		ListNode oneone = new ListNode(1);
		
		one.setNext(two);
		two.setNext(three);
		three.setNext(twotwo);
		twotwo.setNext(oneone);
		
		ListNode result = dedupeWithSpace(one);
		while(result != null) {
			System.out.print(result.getValue() + ", ");
			result = result.getNext();
		}
		System.out.println();
		result = dedupeWithNoSpace(one);
		while(result != null) {
			System.out.print(result.getValue() + ", ");
			result = result.getNext();
		}

	}

	private static ListNode dedupeWithNoSpace(ListNode one) {
		ListNode current = one;
		while(current != null) {
			ListNode runner = current;
			while(runner.getNext() != null) {
				if(current.getValue() == runner.getNext().getValue()) {
					runner.setNext(runner.getNext().getNext());
				} 
				runner = runner.getNext();
			}
			current = current.getNext();
		}
		return one;
	}

	private static ListNode dedupeWithSpace(ListNode one) {
		Set<Integer> nums = new HashSet<>();
		ListNode current = one;
		ListNode prev = null;
		while(current != null) {
			if(nums.contains(current.getValue())) {
				prev.setNext(current.getNext());
				current = prev.getNext();
			} else {
				nums.add(current.getValue());
				prev = current;
				current = current.getNext();
			}
			
		}
		return one;
	}
}
