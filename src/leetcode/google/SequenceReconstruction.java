package leetcode.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import graph.GraphNode;

public class SequenceReconstruction {

	public static void main(String[] args) {
		int[][] seqs = { { 5, 2, 6, 3 }, { 4, 1, 5, 2 } };
		int[] orgs = { 4, 1, 5, 2, 6, 3 };
		
		Map<Integer, GraphNode> graph = new HashMap<Integer, GraphNode>();
		
		for(int i = 0; i < seqs.length; i++) {
			for(int j = 0; j < seqs[0].length; j++) {
				if(!graph.containsKey(seqs[i][j])) {
					GraphNode g = new GraphNode(seqs[i][j]);
					g.setChildren(new ArrayList<>());
					graph.put(seqs[i][j], g);
				}
			}
		}
		
		for(int i = 0; i < seqs.length; i++) {
			for(int j = 1; j < seqs[0].length; j++) {
				GraphNode parent = graph.get(seqs[i][j-1]);
				GraphNode child = graph.get(seqs[i][j]);
				parent.getChildren().add(child);
			}
		}
		
		List<GraphNode> temporaryMarks = new ArrayList<>();
		List<GraphNode> permanentMarks = new ArrayList<>();
		List<GraphNode> result = new LinkedList<GraphNode>();
		
		for(int i : graph.keySet()) {
			if(!permanentMarks.contains(graph.get(i))) {
				visit(graph, graph.get(i), permanentMarks, temporaryMarks, result);
			}
		}
		
		Collections.reverse(result);
		int i = 0;
		for(GraphNode g : result) {
			System.out.print(g.getValue() + "-->");
			if(orgs[i++] != g.getValue()) {
				System.out.println(false);
				return;
			}
		}
		
		System.out.println(true);
	}

	private static void visit(Map<Integer, GraphNode> graph, GraphNode g, List<GraphNode> permanentMarks,
			List<GraphNode> temporaryMarks, List<GraphNode> result) {
		
		if(temporaryMarks.contains(g)) {
			throw new IllegalArgumentException();
		}
		
		if(!permanentMarks.contains(g)) {
			temporaryMarks.add(g);
			for(GraphNode gc : g.getChildren()) {
				visit(graph, gc, permanentMarks, temporaryMarks, result);
			}
			temporaryMarks.remove(g);
			result.add(g);
			permanentMarks.add(g);
		}
	}

}
