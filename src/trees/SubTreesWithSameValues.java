package trees;

import java.util.concurrent.atomic.AtomicInteger;

public class SubTreesWithSameValues {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode four1 = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode five1 = new TreeNode(5);
		TreeNode five2 = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		three.setLeft(five);
		three.setRight(six);
		six.setRight(seven);
		four.setLeft(four1);
		five.setLeft(five1);
		five.setRight(five2);
		
		
		AtomicInteger count = new AtomicInteger(0);
		findSubTreesWithSameValues(one, count);
		System.out.println(count.get());
	}

	private static int findSubTreesWithSameValues(TreeNode root, AtomicInteger count) {
		if(root == null) return Integer.MAX_VALUE;
		
		if(root.getLeft() == null && root.getRight() == null) {
			count.incrementAndGet();
			return root.getValue();
		}
		
		int left = findSubTreesWithSameValues(root.getLeft(), count);
		int right = findSubTreesWithSameValues(root.getRight(), count);
		
		if(left == Integer.MAX_VALUE && right == root.getValue() ||
				right == Integer.MAX_VALUE && left == root.getValue() ||
				left == right && left == root.getValue()) {
			count.incrementAndGet();
			return root.getValue();
		}
		
		return Integer.MAX_VALUE;
	}
}
