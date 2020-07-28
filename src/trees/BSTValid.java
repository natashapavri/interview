package trees;
public class BSTValid {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(5);
		BinaryTreeNode two = new BinaryTreeNode(2);
		BinaryTreeNode seven = new BinaryTreeNode(7);
		root.setLeft(two);
		root.setRight(seven);
		
		BinaryTreeNode one = new BinaryTreeNode(1);
		BinaryTreeNode three = new BinaryTreeNode(3);
		BinaryTreeNode six = new BinaryTreeNode(6);
		BinaryTreeNode four = new BinaryTreeNode(4);
		
		two.setLeft(one);
		two.setRight(three);
		seven.setLeft(six);
		seven.setRight(four);
		
		System.out.println(isValidBST(root));
	}

	private static boolean isValidBST(BinaryTreeNode root) {
		if(root == null) return true;
		if(root.getLeft() != null && root.getLeft().getValue() > root.getValue()) {
			return false;
		}
		if(root.getRight() != null && root.getRight().getValue() < root.getValue()) {
			return false;
		}
		return isValidBST(root.getLeft()) && isValidBST(root.getRight());
	}
}
