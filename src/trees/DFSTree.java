package trees;

public class DFSTree {

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

		dfsPreOrder(root);
		System.out.println();
		dfsPostOrder(root);
		System.out.println();
		dfsInOrder(root);
	}

	private static void dfsInOrder(TreeNode root) {
		if (root == null)
			return;

		dfsInOrder(root.getLeft());
		System.out.print(root.getValue() + "->");
		dfsInOrder(root.getRight());
	}

	private static void dfsPostOrder(TreeNode root) {
		if (root == null)
			return;

		dfsPostOrder(root.getLeft());
		dfsPostOrder(root.getRight());
		System.out.print(root.getValue() + "->");
	}

	private static void dfsPreOrder(TreeNode root) {
		if (root == null)
			return;

		System.out.print(root.getValue() + "->");
		dfsPreOrder(root.getLeft());
		dfsPreOrder(root.getRight());
	}
}
