package trees;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTree {
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
		two.setLeft(four);
		two.setRight(five);
		three.setLeft(six);
		three.setRight(seven);
		
		int depth = maxDepth(root);
		 for (int i=0; i<depth; i++) 
			 printLevelNodes(root, i);
		 
		 printbfs(root);
	}

	private static void printbfs(TreeNode root) {
		if(root == null) return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println(node.getValue());
			if(node.getLeft() != null) queue.add(node.getLeft());
			if(node.getRight() != null) queue.add(node.getRight());
		}
	}

	private static int maxDepth(TreeNode root) {
		if(root == null) return 0;
		return 1 + Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight()));
	}

	private static void printLevelNodes(TreeNode root, int depth) {
		if(root == null) return;
		if(depth == 0)
			System.out.println(root.getValue());
		
		if(depth > 0) {
			printLevelNodes(root.getLeft(), depth -1);
			printLevelNodes(root.getRight(), depth -1);
		}
	}
}
