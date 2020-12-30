package google;

import java.util.Arrays;

public class HeightOrderPeopleBST {

	/**
	 * 
	 * Nodes in BST keep track of how many people are in front of you. 
	 * Left subtree has shorter people than the root while right sub tree has taller people than the root.
	 * Every time you add to left subtree you need to increment value of root to account for one more person ahead of the root.
	 * Every time you add to right subtree, the value of the right node will have nodes at root less. 
	 */
	public static void main(String[] args) {
		int[] heights = { 5, 3, 2, 6, 1, 4 };
		int[] inFront = { 0, 1, 2, 0, 3, 2 };
		
		PersonBST[] people = new PersonBST[heights.length];

		for (int i = 0; i < heights.length; i++) {
			PersonBST p = new PersonBST(heights[i], inFront[i]);
			people[i] = p;
		}

		Arrays.sort(people);
		
		Node root = new Node(people[0]);
		for(int i = 1; i < people.length; i++) {
			insert(people[i], root);
		}
		
		inorderTraverse(root);
	}

	private static void inorderTraverse(Node root) {
		if(root == null) return;
		inorderTraverse(root.getLeft());
		System.out.println(root.getPerson().getHeight());
		inorderTraverse(root.getRight());
	}

	private static void insert(PersonBST personBST, Node root) {
		insert(personBST, root, personBST.getInfront());	
	}

	private static void insert(PersonBST personBST, Node root, int infront) {
		if(root.getValue() > infront) {
			if(root.getLeft() == null) {
				root.setLeft(new Node(personBST));
			}
			else {
				insert(personBST,  root.getLeft(), infront);
			}
			root.setValue(root.getValue() + 1);
		} else {
			if(root.getRight() == null) {
				root.setRight(new Node(personBST));
			} else {
				insert(personBST, root.getRight(), infront - root.getValue());
			}
		}
	}
}

class PersonBST implements Comparable<PersonBST> {
	int height;
	int infront;

	public PersonBST(int height, int infront) {
		super();
		this.height = height;
		this.infront = infront;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getInfront() {
		return infront;
	}

	public void setInfront(int infront) {
		this.infront = infront;
	}

	@Override
	public int compareTo(PersonBST o) {
		return o.getHeight() - this.getHeight();
	}

	@Override
	public String toString() {
		return "Person [height=" + height + ", infront=" + infront + "]";
	}
}

class Node {
	int value;
	Node left;
	Node right;
	PersonBST person;

	public Node(PersonBST person) {
		super();
		this.value = 1;
		this.person = person;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public PersonBST getPerson() {
		return person;
	}

	public void setPerson(PersonBST person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", left=" + left + ", right=" + right + ", person=" + person + "]";
	}

}