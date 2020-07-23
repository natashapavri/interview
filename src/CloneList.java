import java.util.HashMap;
import java.util.Map;

public class CloneList {
	public static void main(String[] args) {
		RandomListNode root = new RandomListNode(1);
		RandomListNode two = new RandomListNode(2);
		RandomListNode three = new RandomListNode(3);
		RandomListNode four = new RandomListNode(4);
		root.setNext(two);
		two.setNext(three);
		three.setNext(four);
		root.setRandom(three);
		two.setRandom(root);
		three.setRandom(three);
		four.setRandom(two);
		
		RandomListNode copy = clone(root);
		while(copy.getNext() != null) {
			System.out.println(copy.getValue() + ", " + copy.getRandom().getValue() + " ," + copy.getNext().getValue());
			copy = copy.getNext();
		}
		
		copy = cloneNoSpace(root);
		while(copy.getNext() != null) {
			System.out.println(copy.getValue() + ", " + copy.getRandom().getValue() + " ," + copy.getNext().getValue());
			copy = copy.getNext();
		}
	}

	private static RandomListNode clone(RandomListNode root) {
		RandomListNode current = root;
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode clone = new RandomListNode(root.getValue());
		RandomListNode currentClone = clone;
		map.put(current, currentClone);
		
		while(current.getNext() != null) {
			current = current.getNext();
			currentClone.setNext(new RandomListNode(current.getValue()));
			currentClone = currentClone.getNext();
			map.put(current, currentClone);
		}
		current = root;
		currentClone = clone;
		while(current != null) {
			RandomListNode random = current.getRandom();
			RandomListNode randomClone = map.get(random);
			currentClone.setRandom(randomClone);
			current = current.getNext();
			currentClone = currentClone.getNext();
		}
		
		return clone;
	}
	
	private static RandomListNode cloneNoSpace(RandomListNode root) {
		
		RandomListNode current = root;
		while(current != null) {
			RandomListNode temp = new RandomListNode(current.getValue());
			temp.setNext(current.getNext());
			current.setNext(temp);
			current = temp.getNext();
		}
		
		current = root;
		while(current != null) {
			current.getNext().setRandom(current.getRandom().getNext());
			current = current.getNext().getNext();
		}
		
		RandomListNode copy = root.getNext();
		current = root;
		while(current.getNext() != null) {
			RandomListNode temp = current.getNext();
			current.setNext(current.getNext().getNext());
			current = temp;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return copy;
	}
}

class RandomListNode {
	private int value;
	private RandomListNode next;
	private RandomListNode random;

	
	public RandomListNode() {
		super();
	}

	public RandomListNode(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public RandomListNode getNext() {
		return next;
	}

	public void setNext(RandomListNode next) {
		this.next = next;
	}

	public RandomListNode getRandom() {
		return random;
	}

	public void setRandom(RandomListNode random) {
		this.random = random;
	}

}