package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		String input = "hit";
		String output = "cog";

		List<String> dict = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

		// word ladder 1
		int length = traverseForOutput(input, output, dict);
		System.out.println(length);

		// word ladder 2
		Set<List<String>> paths = traverseForPaths(input, output, dict);
		System.out.println(paths);
	}

	private static Set<List<String>> traverseForPaths(String input, String output, List<String> dict) {
		Map<WordLadderNode, List<WordLadderNode>> graph = new HashMap<WordLadderNode, List<WordLadderNode>>();
		bfs(graph, input, output, dict);
		Set<List<String>> results = new HashSet<>();
		dfs(graph, results, new WordLadderNode(input, 1), output, new ArrayList<>());
		return results;
	}

	private static void dfs(Map<WordLadderNode, List<WordLadderNode>> graph, Set<List<String>> results,
			WordLadderNode input, String output, List<String> result) {

		if (input.getWord().equals(output)) {
			results.add(new ArrayList<>(result));
		}
		if (graph.containsKey(input)) {
			result.add(input.getWord());
			for (WordLadderNode c : graph.get(input)) {
				dfs(graph, results, c, output, result);
			}
			result.remove(result.size() - 1);
		}
	}

	private static void bfs(Map<WordLadderNode, List<WordLadderNode>> graph, String input, String output,
			List<String> dict) {
		WordLadderNode node = new WordLadderNode(input, 1);

		Queue<WordLadderNode> queue = new LinkedList<>();
		queue.add(node);
		Queue<WordLadderNode> visited = new LinkedList<>();

		while (!queue.isEmpty()) {
			WordLadderNode n = queue.poll();
			visited.add(n);

			for (String word : dict) {
				WordLadderNode w = new WordLadderNode(word, n.getLength() + 1);
				if (isAdjacent(word, n.getWord()) && !visited.contains(w)) {
					graph.putIfAbsent(n, new ArrayList<>());
					graph.get(n).add(w);
					if (word.equals(output)) {
						break;
					}
					queue.add(w);
				}
			}
		}

	}

	private static int traverseForOutput(String input, String output, List<String> dict) {
		if (input.equals(output))
			return 0;

		Queue<WordLadderNode> queue = new LinkedList<WordLadderNode>();
		queue.add(new WordLadderNode(input, 1));
		Queue<WordLadderNode> visited = new LinkedList<WordLadderNode>();

		while (!queue.isEmpty()) {
			WordLadderNode node = queue.poll();
			visited.add(node);
			for (String word : dict) {
				WordLadderNode n = new WordLadderNode(word, node.getLength() + 1);
				if (isAdjacent(word, output)) {
					return n.getLength() + 1; //have to count the output node
				}
				if (isAdjacent(word, node.getWord()) && !visited.contains(n)) {
					queue.add(n);
					break;
				}
			}
		}

		return 0;
	}

	private static boolean isAdjacent(String n, String node) {
		if (n.length() != node.length())
			return false;

		int i = 0, count = 0;
		while (i < node.length()) {
			if (node.charAt(i) != n.charAt(i)) {
				count++;
			}
			i++;
		}

		if (count == 1)
			return true;
		return false;
	}
}

class WordLadderNode {
	private String word;
	private int length;

	public WordLadderNode(String word, int length) {
		super();
		this.word = word;
		this.length = length;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "WordLadderNode [word=" + word + ", length=" + length + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordLadderNode other = (WordLadderNode) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

}