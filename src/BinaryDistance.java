
public class BinaryDistance {

	public static void main(String[] args) {
		String[] binaries = { "1011100", "1011011", "1001111" };

		BinaryTrieNode root = new BinaryTrieNode('\0');
		BinaryTrie tree = new BinaryTrie(root);
		
		for (String str : binaries) {
			prepareDictionary(str, root);
		}
		
		System.out.println(tree.getMaxDiff());

	}

	private static void prepareDictionary(String str, BinaryTrieNode root) {
		BinaryTrieNode current = root;
		for (char c : str.toCharArray()) {
			BinaryTrieNode node = current.get(c);
			if (node == null) {
				node = new BinaryTrieNode(c);
				current.set(c, node);
			}
			current = node;
		}
	}
}

class BinaryTrieNode {
	private char c;
	private BinaryTrieNode left;
	private BinaryTrieNode right;
	
	public BinaryTrieNode(char c) {
		super();
		this.c = c;
	}
	public char getC() {
		return c;
	}
	public void setC(char c) {
		this.c = c;
	}
	public BinaryTrieNode getLeft() {
		return left;
	}
	public void setLeft(BinaryTrieNode left) {
		this.left = left;
	}
	public BinaryTrieNode getRight() {
		return right;
	}
	public void setRight(BinaryTrieNode right) {
		this.right = right;
	}
	
	public void set(char c, BinaryTrieNode node) {
		if(c == '0') {
			left = node;
		} else {
			right = node;
		}
	}
	
	public BinaryTrieNode get(char c) {
		if(c == '0') {
			return left;
		} else {
			return right;
		}
	}
	
	@Override
	public String toString() {
		return "BinaryTrieNode [c=" + c + ", left=" + left + ", right=" + right + "]";
	}
	
	
}
class BinaryTrie {
	
	int maxDiff = 0;
	private BinaryTrieNode root;
	
	public BinaryTrie(BinaryTrieNode root) {
		super();
		this.root = root;
	}

	public int getMaxDepth(BinaryTrieNode root) {
		if (root == null)
			return 0;
		int leftDepth = getMaxDepth(root.getLeft());
		int rightDepth = getMaxDepth(root.getRight());
		
		if(leftDepth > 0 && rightDepth > 0) {
			maxDiff = Math.max(maxDiff, leftDepth + rightDepth);
		}
		return 1 + Math.max(leftDepth, rightDepth);
	}
	
	public int getMaxDiff() {
		getMaxDepth(root);
		return maxDiff;
	}

}
