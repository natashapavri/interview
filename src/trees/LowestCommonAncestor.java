package trees;
import java.util.Stack;

public class LowestCommonAncestor {

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
		
		// bottom up
		TreeNode ancestor = findAncestor(four, five);
		System.out.println(ancestor.getValue());
		
		// top down
		Stack<TreeNode> pathToA = findPath(root, four);
		Stack<TreeNode> pathToB = findPath(root, five);
		int pathADistance = pathToA.size() -1;
		int pathBDistance = pathToB.size() -1;
		
		int distanceAncestor = 0;
		while(!pathToA.isEmpty() && !pathToB.isEmpty()) {
			TreeNode a = pathToA.pop();
			TreeNode b = pathToB.pop();
			if(a == b) {
				ancestor = a;
			} else {
				distanceAncestor++;
			}
		}
		
		System.out.println(ancestor.getValue());
		
		// distance b/w nodes = distance of node 1 from root + distance of node 2 from root - 2 * distance of ancestor from root
		int countPathEdges = (pathADistance) + (pathBDistance) - (2* distanceAncestor);
		System.out.println(countPathEdges);
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

	private static TreeNode findAncestor(TreeNode a, TreeNode b) {
		if(a == null || b == null) return null;
		
		while(a!= null && b!=null) {
			if(a == b) return a;
			if(a.getParent() != null)
				a = a.getParent();
			if(b.getParent() != null)
				b = b.getParent();
		}
		
		return null;
	}
}

