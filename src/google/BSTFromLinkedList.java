package google;

import trees.TreeNode;

public class BSTFromLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
		
		head.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(five);
		five.setNext(six);
		six.setNext(null);
		
		TreeNode root = createBST(head);
		
		preOrderTraverse(root);
	}

	private static TreeNode createBST(ListNode head) {
		ListNode leftEnd = getMiddle(head);
		if(leftEnd == null) return new TreeNode(head.getValue());
		ListNode left = head;
		ListNode mid = leftEnd.getNext();
		leftEnd.setNext(null);
		ListNode midNext = mid.getNext();
		mid.setNext(null);
		ListNode right = midNext;
		
		TreeNode root = new TreeNode(mid.getValue());
		
		if(left != null)
			root.setLeft(createBST(left));
		if(right != null)
			root.setRight(createBST(right));
		
		return root;
	}

	private static ListNode getMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		ListNode previous = null;
		while(fast != null && fast.getNext()!=null) {
			previous = slow;
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		return previous;
	}

	private static void preOrderTraverse(TreeNode root) {
		if(root == null) return;
		System.out.println(root.getValue());
		preOrderTraverse(root.getLeft());
		preOrderTraverse(root.getRight());
	}
}
