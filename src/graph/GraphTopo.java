package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GraphTopo {
	// a list to hold all the edges for each node/ vertex
	private Map<Character, List<Character>> edges;
	// a list of hold all the nodes
	private List<Character> nodes;
	// a list to indicate nodes that were visited/ traversed
	private List<Character> nodeVisited;
	// a list to hold all the edges
	private List<Character> edgeList;

	// a public constructor to set the nodes and intialize edge list
	public GraphTopo(List<Character> vertices) {
		this.nodes = vertices;
		this.edges = new HashMap<>();
		this.nodeVisited = new ArrayList<>();
	}

	// method to add edge to a node. i.e. adding edges for given nodes.
	public void addEdge(Character x, Character y) {

		// If the node (key) and edge (value) are being added for first time
		if (!edges.containsKey(x)) {
			edgeList = new ArrayList<>();
		} else {
			// if the node already has edges added
			edgeList = edges.get(x);
		}
		edgeList.add(y);
		edges.put(x, edgeList);
	}

	// method containing the logic to sort the given nodes recursively
	public Stack<Character> topologicalSort() {
		Stack<Character> stack = new Stack<>();
		// iterate through all the nodes and their neighbors if not already
		// visited.
		for (Character c : nodes) {
			if (!nodeVisited.contains(c)) {
				sort(c, stack);
			}
		}
		return stack;
	}

	// this recursive method iterates through all the nodes and neighbors.
	// Pushes the visited items to stack
	public void sort(Character ch, Stack<Character> stack) {
		// add the visited node to list, so we don't repeat this node again
		nodeVisited.add(ch);
		// the leaf nodes wouldn't have neighbors. A check added to avoid null
		// pointer
		if (edges.get(ch) != null) {
			// get all the neighbor nodes , by referring its edges
			List<Character> neighbors = edges.get(ch);
			for(Character c : neighbors) {
				if(!nodeVisited.contains(c)) {
					sort(c, stack);
				}
			}
		}
		// push the latest node on to the stack
		stack.push(new Character(ch));
	}
}
