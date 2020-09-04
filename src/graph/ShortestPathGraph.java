package graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ShortestPathGraph {

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

		List<GraphNode> result = findShortestPath(two, three);
		for (GraphNode g : result) {
			System.out.print(g.getValue() + "-->");
		}
	}

	private static List<GraphNode> findShortestPath(GraphNode a, GraphNode b) {
		if (a == null || b == null) {
			return null;
		}
		if (a == b)
			return null;

		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(a);

		Map<GraphNode, GraphNode> parent = new HashMap<>();
		parent.put(a, null);

		while (!queue.isEmpty()) {
			GraphNode current = queue.remove();
			if (current.getChildren() == null)
				continue;
			if (current == b)
				break;

			for (GraphNode g : current.getChildren()) {
				//node is not visited before
				if (!parent.containsKey(g)) {
					queue.add(g);
					parent.put(g, current);
				}
			}
		}

		//no path
		if (parent.get(b) == null)
			return null;

		List<GraphNode> result = new ArrayList<>();
		GraphNode g = b;
		while (g != null) {
			result.add(g);
			g = parent.get(g);
		}

		return result;
	}
}
