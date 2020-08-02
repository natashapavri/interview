package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DFSGraph {

	public static void main(String[] args) {
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		GraphNode five = new GraphNode(5);

		List<GraphNode> children1 = new ArrayList<GraphNode>(Arrays.asList(three, two));
		one.setChildren(children1);

		List<GraphNode> children2 = new ArrayList<GraphNode>(Arrays.asList(five));
		two.setChildren(children2);

		List<GraphNode> children4 = new ArrayList<GraphNode>(Arrays.asList(three, one));
		four.setChildren(children4);

		List<GraphNode> children5 = new ArrayList<GraphNode>(Arrays.asList(four));
		five.setChildren(children5);

		List<GraphNode> visited = new ArrayList<>();
		List<GraphNode> traverse = new LinkedList<>();
		dfs(one, traverse, visited);
		
		for(GraphNode g : traverse) {
			System.out.print(g.getValue() + "->");
		}
	}

	
	private static void dfs(GraphNode one, List<GraphNode> traverse, List<GraphNode> visited) {
		visited.add(one);
		traverse.add(one);
		if(one.getChildren() != null) {
			for(GraphNode child : one.getChildren()) {
				if(!visited.contains(child)) {
					dfs(child, traverse, visited);
				}
			}
		}
	}
}
