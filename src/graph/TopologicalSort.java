package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

	public static void main(String[] args) {
		Map<Integer, GraphNode> map = new HashMap<>();
		GraphNode one = new GraphNode(1,5);
		GraphNode two = new GraphNode(2,-2);
		GraphNode three = new GraphNode(3,10);
		GraphNode four = new GraphNode(4,-3);
		GraphNode five = new GraphNode(5,-4);
		GraphNode six = new GraphNode(6,8);

		map.put(1, one);
		map.put(2, two);
		map.put(3, three);
		map.put(4, four);
		map.put(5, five);
		map.put(6, six);

		List<GraphNode> children1 = new ArrayList<GraphNode>(Arrays.asList(two));
		one.setChildren(children1);

		List<GraphNode> children2 = new ArrayList<GraphNode>(Arrays.asList(three));
		two.setChildren(children2);

		List<GraphNode> children3 = new ArrayList<GraphNode>(Arrays.asList(six));
		three.setChildren(children3);

		List<GraphNode> children4 = new ArrayList<GraphNode>(Arrays.asList(one, five));
		four.setChildren(children4);

		List<GraphNode> children5 = new ArrayList<GraphNode>(Arrays.asList(three, two));
		five.setChildren(children5);

		List<GraphNode> visited = new ArrayList<>();
		List<GraphNode> temporaryMarks = new ArrayList<>();
		List<GraphNode> permanentMarks = new ArrayList<>();
		List<GraphNode> result = new ArrayList<>();

		for (Integer i : map.keySet()) {
			if (!visited.contains(map.get(i)) && !permanentMarks.contains(map.get(i))) {
				toposort(visited, map.get(i), temporaryMarks, permanentMarks, result);
			}
		}
		
		// needed for graph
		Collections.reverse(result);
		
		for(GraphNode c : result) {
			System.out.print(c.getValue() + "->");
		}
		
	}

	private static void toposort(List<GraphNode> visited, GraphNode graphNode, List<GraphNode> temporaryMarks,
			List<GraphNode> permanentMarks, List<GraphNode> result) {
		if (temporaryMarks.contains(graphNode)) {
			throw new IllegalArgumentException();
		}

		if (!permanentMarks.contains(graphNode)) {
			visited.add(graphNode);
			temporaryMarks.add(graphNode);

			if (graphNode.getChildren() != null) {
				for (GraphNode child : graphNode.getChildren()) {
					toposort(visited, child, temporaryMarks, permanentMarks, result);
				}
			}
			
			permanentMarks.add(graphNode);
			result.add(graphNode);
			temporaryMarks.remove(graphNode);
		}
	} 	
}
