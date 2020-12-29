package google;

import trees.TreeNode;

public class BinaryTreeFromArray {

	public static void main(String[] args) {
		int[] nums = { 5, 3, 2, 6, 1, 4 };

		TreeNode root = new TreeNode();

		root = insertIntoTree(nums, root, 0);

		preOrderTraverse(root);
	}

	private static void preOrderTraverse(TreeNode root) {
		if (root != null) {
			System.out.println(root.getValue());
			preOrderTraverse(root.getLeft());
			preOrderTraverse(root.getRight());
		}
	}

	private static TreeNode insertIntoTree(int[] nums, TreeNode root, int level) {

		if (level >= nums.length)
			return root;

		TreeNode node = new TreeNode(nums[level]);
		root = node;

		root.setLeft(insertIntoTree(nums, root.getLeft(), 2 * level + 1));
		root.setRight(insertIntoTree(nums, root.getRight(), 2 * level + 2));

		return root;
	}
}
