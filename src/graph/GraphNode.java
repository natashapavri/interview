package graph;

import java.util.List;

public class GraphNode {
	private int value;
	private int weight;
	List<GraphNode> children;

	
	public GraphNode(int value, int weight) {
		super();
		this.value = value;
		this.weight = weight;
	}

	public GraphNode() {
		super();
	}

	public GraphNode(int value) {
		super();
		this.value = value;
		this.children = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<GraphNode> getChildren() {
		return children;
	}

	public void setChildren(List<GraphNode> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "GraphNode [value=" + value + ", weight=" + weight + ", children=" + children + "]";
	}
	
}