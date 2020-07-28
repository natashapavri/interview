package trees;
import java.util.LinkedList;
import java.util.Queue;

public class GCDTRee {

	public static void main(String[] args) {
		
		BinaryTreeNode root = new BinaryTreeNode(7);
		BinaryTreeNode five = new BinaryTreeNode(5);
		BinaryTreeNode ten = new BinaryTreeNode(10);
		BinaryTreeNode four = new BinaryTreeNode(4);
		BinaryTreeNode eight = new BinaryTreeNode(8);
		BinaryTreeNode three = new BinaryTreeNode(3);
		BinaryTreeNode six = new BinaryTreeNode(6);
		
		root.setLeft(five);
		root.setRight(ten);
		five.setLeft(four);
		five.setRight(eight);
		ten.setLeft(three);
		ten.setRight(six);
		
		findGCD(root);

	}

	private static void findGCD(BinaryTreeNode root) {
		if (root == null)
			return;

		Integer min_gcd = Integer.MAX_VALUE;
		Integer max_gcd = Integer.MIN_VALUE;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();

		if (root.getLeft() != null && root.getRight() != null) {
			queue.add(root.getLeft());
			queue.add(root.getRight());
		}

		while (!queue.isEmpty()) {
			BinaryTreeNode left = queue.poll();
			BinaryTreeNode right = queue.poll();
			int gcd = getGCD(left.getValue(), right.getValue());
			if (min_gcd > gcd) {
				min_gcd = gcd;
			}
			if (max_gcd < gcd) {
				max_gcd = gcd;
			}
			if (left.getLeft() != null && left.getRight() != null) {
				queue.add(left.getLeft());
				queue.add(left.getRight());
			}
			if (right.getLeft() != null && right.getRight() != null) {
				queue.add(right.getLeft());
				queue.add(right.getRight());
			}
		}
		
		System.out.println(max_gcd - min_gcd);
	}

	private static int getGCD(int value1, int value2) {
		if (value1 == 0 || value2 == 0)
			return 0;
		if (value1 == 1 || value2 == 1)
			return 1;

		int gcd = 1;
		for (int i = 1; i<=value1 && i<=value2; i++) {
			if(value1 % i == 0 && value2 % i == 0)
				gcd= i;
		}

		return gcd;
	}

}
