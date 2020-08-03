package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CyclicGraph {

	public static void main(String[] args) {
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);

		List<GraphNode> children1 = new ArrayList<GraphNode>(Arrays.asList(two));
		one.setChildren(children1);

		List<GraphNode> children2 = new ArrayList<GraphNode>(Arrays.asList(three));
		two.setChildren(children2);
		
		List<GraphNode> children3 = new ArrayList<GraphNode>(Arrays.asList(three));
		three.setChildren(children3);

		boolean isCyclic = checkCyclic(one);
		System.out.println(isCyclic);
	}

	static Map<GraphNode, GraphNode> parent = new HashMap<GraphNode, GraphNode>();
	
	private static boolean checkCyclic(GraphNode one) {
		if(!parent.containsKey(one)) {
			parent.put(one, null);
		}
		
		boolean isCyclic = false;
		if(one.getChildren() != null) {
			for(GraphNode child : one.getChildren()) {
				if(parent.containsKey(child)) {
					isCyclic = true;
					break;
				}
				else {
					parent.put(child, one);
					isCyclic = checkCyclic(child);
				}
			}
		}
		return isCyclic;
	}
}
