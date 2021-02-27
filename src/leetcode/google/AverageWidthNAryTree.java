package leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trees.TreeNode;

public class AverageWidthNAryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		
		root.setLeft(two);
		root.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		three.setLeft(six);
		three.setRight(seven);
		
		Map<Integer, Double> widthMap = new HashMap<Integer, Double>();
		findWidthMap(root, widthMap);
		for(Integer k : widthMap.keySet()) {
			System.out.println(k + " : " + widthMap.get(k));
		}
	}

	private static void findWidthMap(TreeNode root, Map<Integer, Double> widthMap) {
		if(root == null) return;
		
		Map<Integer, Integer> totalNodes = new HashMap<>();
		List<List<Integer>> levelNodes = new ArrayList<>();
		
		dfs(root, 1, totalNodes, levelNodes);
		
		for(int i = 0; i < levelNodes.size(); i++) {
			int levelBelow = levelNodes.size() - i;
			List<Integer> level = levelNodes.get(i);
			for(int node : level) {
				int childNodes = totalNodes.get(node);
				double avg = (double) childNodes/levelBelow;
				widthMap.put(node, avg);
			}
		}
		
	}

	private static int dfs(TreeNode root, int level, Map<Integer, Integer> totalNodes, List<List<Integer>> levelNodes) {
		if(root == null) return 0;
		if(levelNodes.size() < level) {
			// make new level array for each level
			levelNodes.add(new ArrayList<>());
		}
		levelNodes.get(level - 1).add(root.getValue());
		
		int left = dfs(root.getLeft(), level + 1, totalNodes, levelNodes);
		int right = dfs(root.getRight(), level + 1, totalNodes, levelNodes);
		totalNodes.put(root.getValue(), left + right + 1);

		return left + right + 1;
	}
}
