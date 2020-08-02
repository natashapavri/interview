package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BiPartiteGraphCheck {

	public static void main(String[] args) {
		GraphNode one= new GraphNode(1);
		GraphNode two= new GraphNode(2);
		GraphNode three= new GraphNode(3);
		GraphNode four= new GraphNode(4);
		GraphNode five= new GraphNode(5);
		
		List<GraphNode> children1 = Arrays.asList(two);
		one.setChildren(children1);
		
		List<GraphNode> children2 = Arrays.asList(three);
		two.setChildren(children2);
		
		List<GraphNode> children3 = Arrays.asList(five);
		three.setChildren(children3);
		
		List<GraphNode> children4 = Arrays.asList(one);
		four.setChildren(children4);
		
		List<GraphNode> children5 = Arrays.asList(two, four);
		five.setChildren(children5);
		
		boolean value = checkBiPartite(one, 1);
		System.out.println(value);
	}

	static List<GraphNode> red = new ArrayList<>();
	static List<GraphNode> blue = new ArrayList<>();
	private static boolean checkBiPartite(GraphNode one, int i) {
		if(i%2 != 0) {
			if(red.contains(one)) {
				return false;
			}
			else {
				blue.add(one);
			}
		}
		else {
			if(blue.contains(one)) {
				return false;
			} else {
				red.add(one);
			}
		}
			
		
		if(one.getChildren() != null) {
			for(GraphNode child : one.getChildren()) {
				return checkBiPartite(child, i+1);
			}
		}
		
		return true;
	}
}
