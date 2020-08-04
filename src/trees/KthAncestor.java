package trees;

import java.util.Stack;

public class KthAncestor {

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
		root.setParent(null);
		two.setLeft(four);
		two.setRight(five);
		two.setParent(root);
		four.setParent(two);
		five.setParent(two);
		three.setLeft(six);
		three.setRight(seven);
		three.setParent(root);
		six.setParent(three);
		seven.setParent(three);
		
		//bottom up
		int k = 2;
		TreeNode ancestor = findKthAncestor(six, k);
		System.out.println(ancestor.getValue());
		
		k = 1;
		ancestor = findKthAncestor(four, k);
		System.out.println(ancestor.getValue());
		
		//top down 
		k = 1;
		Stack<TreeNode> path = findPath(root, four);
		while(k>=0) {
			ancestor = path.pop();
			k--;
		}
		System.out.println(ancestor.getValue());
	}

	private static Stack<TreeNode> findPath(TreeNode root, TreeNode node) {
		if(root == null || node == null) return null;
		if(root == node) {
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);
			return stack;
		}
		
		Stack<TreeNode> left = findPath(root.getLeft(), node);
		Stack<TreeNode> right = findPath(root.getRight(), node);
		
		if(left != null) {
			left.push(root);
			return left;
		}
		
		if(right != null) {
			right.push(root);
			return right;
		}
		
		return null;
	}

	private static TreeNode findKthAncestor(TreeNode node, int k) {
		if(node == null) return null;
		TreeNode ancestor = null;
		
		if(k==0) {
			ancestor = node;
		}
		else if(node.getParent() != null) {
			k-=1;
			ancestor = findKthAncestor(node.getParent(), k);
		}
		
		return ancestor;
	}
}
