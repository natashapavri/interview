
public class CyclicLinkedList {

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		
		root.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(two);
		
		ListNode cyclic = findCycle(root);
		
		System.out.println(cyclic.getValue());
	}

	private static ListNode findCycle(ListNode root) {
		ListNode s = root;
		ListNode f = root;
		while(f.getNext() != null) {
			s = s.getNext();
			f = f.getNext().getNext();
			if(s == f) {
				break;
			}
		}
		System.out.println(s.getValue() + ", " + f.getValue());
		s = root;
		while(s != f) {
			s = s.getNext();
			f = f.getNext();
		}
		System.out.println(s.getValue() + ", " + f.getValue());
		
		return f;
	}
}
