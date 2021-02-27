package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DelayedProjectCharacters {

	public static void main(String[] args) {
		char[][] projects = {{'B','A'}, {'C','B'}, {'C','E'},{'D','C'},{'D','F'},{'E','A'},{'F','E'},{'G','F'}};
		Set<Character> delayed = new HashSet<>();
		delayed.add('B');
		delayed.add('F');
		
		List<Character> vertices = Arrays.asList('A','B','C','D','E','F','G');
		
		GraphTopo g = new GraphTopo(vertices);
		for(char[] arr : projects) {
			g.addEdge(arr[1], arr[0]);
		}
		Stack<Character> stack = g.topologicalSort();
		List<Character> order = new LinkedList<>();
		while(!stack.isEmpty()) {
			System.out.print(stack.peek()+"-->");
			order.add(stack.pop());
		}
		System.out.println();
		for(Character c : order) {
			if(delayed.contains(c)) {
				order = order.subList(order.indexOf(c), order.size());
				break;
			}
		}
		
		for(Character c : order) {
			System.out.print(c + "-->");
		}
		
	}

	
}


