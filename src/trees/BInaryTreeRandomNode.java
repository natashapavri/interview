package trees;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BInaryTreeRandomNode {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(5);
		BinaryTreeNode two = new BinaryTreeNode(2);
		BinaryTreeNode seven = new BinaryTreeNode(7);
		root.setLeft(two);
		root.setRight(seven);
		
		BinaryTreeNode one = new BinaryTreeNode(1);
		BinaryTreeNode three = new BinaryTreeNode(3);
		two.setLeft(one);
		two.setRight(three);
		
		BinaryTreeNode six = new BinaryTreeNode(6);
		BinaryTreeNode eight = new BinaryTreeNode(8);
		seven.setLeft(six);
		seven.setRight(eight);
		
		List<BinaryTreeNode> preorder = new ArrayList<BinaryTreeNode>();
		getTotalNodes(root, preorder);
		
		BinaryTreeNode rand = getRandomNode(root, preorder);
		System.out.println(rand.getValue());
	}

	private static BinaryTreeNode getRandomNode(BinaryTreeNode root, List<BinaryTreeNode> preorder) {
		Random rand = new Random();
		int r = rand.nextInt(preorder.size());
		return preorder.get(r);
	}
	
	private static void getTotalNodes(BinaryTreeNode node, List<BinaryTreeNode> preorder) {
		if(node != null) {
			preorder.add(node);
		}
		if(node.getLeft() != null) getTotalNodes(node.getLeft(), preorder);
		if(node.getRight() != null) getTotalNodes(node.getRight(), preorder);
	}
}

class BinaryTreeNode {
	private int value;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	public BinaryTreeNode(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

}