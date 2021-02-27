package leetcode.google;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class SquareWithPoint {

	// Time complexity = O(n^2)
	// Space complexity = O(n ^ 2)
	public static void main(String[] args) {
		int[][] points = {{0,2},{5,0},{1,2},{0,0},{2,0}};
		int[] newPoint = {2,2};
		
		TreeMap<Integer, TreeSet<Integer>> pointMap = new TreeMap<>();
		for(int[] point : points) {
			int x = point[0];
			int y = point[1];
			
			if(pointMap.containsKey(x)) {
				pointMap.get(x).add(y);
			} else {
				pointMap.put(x, new TreeSet<>());
				pointMap.get(x).add(y);
			}
		}
		
		if(pointMap.containsKey(newPoint[0])) {
			pointMap.get(newPoint[0]).add(newPoint[1]);
		} else {
			pointMap.put(newPoint[0], new TreeSet<>());
			pointMap.get(newPoint[0]).add(newPoint[1]);
		}
		
		List<TreeSet<Integer>> arr = new ArrayList<TreeSet<Integer>>();
		for(TreeSet<Integer> t : pointMap.values()) {
			arr.add(t);
		}
		
		for(int i = 0; i < arr.size(); i++) {
			for(int j = i + 1; j < arr.size(); j++) {
				TreeSet<Integer> a = arr.get(i);
				TreeSet<Integer> b = arr.get(j);
				int count = findIntersection(a, b);
				if(count >= 2) {
					System.out.println("Found square");
					return;
				}
			}
		}
		System.out.println("No square found");
	}

	private static int findIntersection(TreeSet<Integer> a, TreeSet<Integer> b) {
		TreeSet<Integer> newA = new TreeSet<>(a);
		newA.retainAll(b);
		return newA.size();
	}
}
