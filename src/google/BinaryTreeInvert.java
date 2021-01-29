package google;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import trees.TreeNode;

public class BinaryTreeInvert {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		TreeNode root = prepareBinaryTree(new TreeNode(), nums, 0);
		
		preOrderTraverse(root);
		
		invertTree(root);
		
		System.out.println();
		
		preOrderTraverse(root);
	}

	private static void invertTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node.getLeft() != null && node.getRight() != null) {
				TreeNode t = new TreeNode();
				t = node.getLeft();
				node.setLeft(node.getRight());
				node.setRight(t);
			}
			if(node.getLeft() != null)
				queue.add(node.getLeft());
			if(node.getRight() != null)
				queue.add(node.getRight());
		}
	}

	private static void preOrderTraverse(TreeNode root) {
		if(root == null) return;
		
		System.out.print(root.getValue() + ", ");
		preOrderTraverse(root.getLeft());
		preOrderTraverse(root.getRight());
		
	}

	private static TreeNode prepareBinaryTree(TreeNode root, int[] nums, int level) {
		if(level < nums.length) {
			TreeNode node = new TreeNode(nums[level]);
			root = node;
			
			root.setLeft(prepareBinaryTree(root.getLeft(), nums, 2 * level + 1));
			root.setRight(prepareBinaryTree(root.getRight(), nums, 2 * level + 2));
		}
		
		return root;
	}
}
