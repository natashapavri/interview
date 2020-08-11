package google;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LinkedListKSort {

	public static void main(String[] args) {
		int k = 3;
		ListNode[] lists = new ListNode[k];
		ListNode a = new ListNode(1);
		ListNode a1 = new ListNode(10);
		ListNode a2 = new ListNode(20);
		a.setNext(a1);
		a1.setNext(a2);
		lists[0] = a;

		ListNode b = new ListNode(4);
		ListNode b1 = new ListNode(11);
		ListNode b2 = new ListNode(13);
		b.setNext(b1);
		b1.setNext(b2);
		lists[1] = b;

		ListNode c = new ListNode(3);
		ListNode c1 = new ListNode(8);
		ListNode c2 = new ListNode(9);
		c.setNext(c1);
		c1.setNext(c2);
		lists[2] = c;

		ListNode result = mergeKLists(lists, k);

		while (result != null) {
			System.out.print(result.getValue() + "-->");
			result = result.getNext();
		}
		
		System.out.println();
		
		ListNode heapResult = heapSort(lists, k);
		
		while (heapResult != null) {
			System.out.print(heapResult.getValue() + "-->");
			heapResult = heapResult.getNext();
		}
	}

	private static ListNode heapSort(ListNode[] lists, int k) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		
		for(ListNode node : lists) {
			ListNode current = node;
			while(current != null) {
				queue.add(current);
				current = current.getNext();
			}
		}
		
		return queue.poll();
	}

	private static ListNode mergeKLists(ListNode[] lists, int k) {

		int last = k - 1;
		
		while(last != 0) {
			int i = 0;
			int j = last;
			
			while (i < j) {
				lists[i] = mergeLists(lists[i], lists[j]);
				i++;
				j--;
				
				if(i >= j) {
					last = j;
				}
			}
		}
		

		return lists[0];
	}

	private static ListNode mergeLists(ListNode a, ListNode b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		
		ListNode result = null;
		
		if(a.getValue() <= b.getValue()) {
			result = a;
			result.setNext(mergeLists(a.getNext(), b));
		} else {
			result = b;
			result.setNext(mergeLists(a, b.getNext()));
		}
		
		return result;
	}
}
