package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graph.GraphNode;

public class SubsequenceReconstruction {

	public static void main(String[] args) {
		int[] org = {1,2,3};
		
		Map<Integer, GraphNode> map = new HashMap<>();
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);

		map.put(1, one);
		map.put(2, two);
		map.put(3, three);

		List<GraphNode> children1 = new ArrayList<GraphNode>(Arrays.asList(two, three));
		one.setChildren(children1);

		List<GraphNode> children2 = new ArrayList<GraphNode>(Arrays.asList(three));
		two.setChildren(children2);

		
		boolean result = sequenceReconstruction(org, map);
		System.out.println(result);
	}
		
	private static boolean sequenceReconstruction(int[] org, Map<Integer, GraphNode> map) {

		List<GraphNode> visited = new ArrayList<>();
		List<GraphNode> temporaryMarks = new ArrayList<>();
		List<GraphNode> permanentMarks = new ArrayList<>();
		List<GraphNode> result = new ArrayList<>();

        
		for (Integer i : map.keySet()) {
			if (!visited.contains(map.get(i)) && !permanentMarks.contains(map.get(i))) {
				visit(visited, map.get(i), temporaryMarks, permanentMarks, result);
			}
		}
        
		Collections.reverse(result);
		
        for(int i = 0; i<result.size();i++) {
            if(result.get(i).getValue() != org[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    private static void visit(List<GraphNode> visited, GraphNode graphNode
                       , List<GraphNode> temporaryMarks, List<GraphNode> permanentMarks
                      , List<GraphNode> result ) {
        
        if(permanentMarks.contains(graphNode)) {
            throw new IllegalArgumentException("Not possible");
        }
        
        if(!temporaryMarks.contains(graphNode)) {
            permanentMarks.add(graphNode);
            
            if(graphNode.getChildren() != null) {
            	for(GraphNode node : graphNode.getChildren()) {
            		visit(visited, node, temporaryMarks, permanentMarks, result);
            	}
            }
            
            temporaryMarks.add(graphNode);
            permanentMarks.remove(graphNode);
            result.add(graphNode);
        }
    }
}
