package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSGraph {

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

		List<GraphNode> traverse = new LinkedList<>();
		bfs(one, traverse);
		
		for(GraphNode g : traverse) {
			System.out.print(g.getValue() + "->");
		}
	}

	private static void bfs(GraphNode one, List<GraphNode> traverse) {
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		Map<GraphNode, GraphNode> parent = new HashMap<GraphNode, GraphNode>();
		queue.add(one);
		parent.put(one, null);
		
		while(!queue.isEmpty()) {
			GraphNode node = queue.poll();
			traverse.add(node);
			if(node.getChildren() != null) {
				for(GraphNode child : node.getChildren()) {
					if(!parent.containsKey(child)) {
						queue.add(child);
						parent.put(child, node);
					}
				}
			}
			
		}
	}
}
