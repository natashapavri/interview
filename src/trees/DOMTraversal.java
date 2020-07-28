package trees;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DOMTraversal {

	public static void main(String[] args) {
		DOMNode root1 = new DOMNode("html", true);
		DOMNode title1 = new DOMNode("title", true);
		DOMNode text1 = new DOMNode("Hello", false);
		root1.setChildren(Arrays.asList(title1));
		title1.setChildren(Arrays.asList(text1));

		DOMNode root2 = new DOMNode("html", true);
		DOMNode title2 = new DOMNode("body", true);
		DOMNode text2 = new DOMNode("hello", false);
		root2.setChildren(Arrays.asList(title2));
		title2.setChildren(Arrays.asList(text2));

		System.out.println(isEqualDoc(root1, root2));
	}

	private static boolean isEqualDoc(DOMNode root1, DOMNode root2) {
		if (root1 == null || root2 == null)
			return false;
		Stack<DOMNode> nodes1 = new Stack<>();
		Stack<DOMNode> nodes2 = new Stack<>();
		findTextNodes(root1, nodes1);
		findTextNodes(root2, nodes2);

		while (!nodes1.isEmpty() && !nodes2.isEmpty()) {
			if (!nodes1.pop().equals(nodes2.pop()))
				return false;
		}
		return true;
	}

	private static void findTextNodes(DOMNode root, Stack<DOMNode> nodes) {
		if (root.isMeta == false) {
			nodes.add(root);
		}
		if (root.getChildren() != null) {
			for (DOMNode child : root.getChildren()) {
				findTextNodes(child, nodes);
			}
		}
	}
}

class DOMNode {
	private String value;
	boolean isMeta;
	List<DOMNode> children;

	public DOMNode(String value, boolean isMeta) {
		super();
		this.value = value;
		this.isMeta = isMeta;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isMeta() {
		return isMeta;
	}

	public void setMeta(boolean isMeta) {
		this.isMeta = isMeta;
	}

	public List<DOMNode> getChildren() {
		return children;
	}

	public void setChildren(List<DOMNode> children) {
		this.children = children;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isMeta ? 1231 : 1237);
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DOMNode other = (DOMNode) obj;
		if (isMeta != other.isMeta)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
