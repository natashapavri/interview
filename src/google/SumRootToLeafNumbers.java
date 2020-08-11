package google;

import trees.TreeNode;

public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);

		root.setLeft(two);
		root.setRight(three);
		two.setLeft(five);
		two.setRight(seven);
		three.setLeft(four);
		three.setRight(six);

		long sum = findSum(root, 0);

		System.out.println(sum % 1003);
	}

	private static long findSum(TreeNode node, long sum) {
		if (node == null)
			return 0;

		if(node.getLeft() == null && node.getRight() == null) return sum;
		
		sum = sum * 10 + node.getValue();

		return findSum(node.getLeft(), sum) + findSum(node.getRight(), sum);
	}
}