package list;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class BestFruit {

	public static void main(String[] args) {
		int N = 4;
		int M = 5;
		int[][] votes = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 2, 4, 3, 1 }, { 3, 4, 2, 1 }, { 4, 3, 2, 1 } };
		Set<Integer> deletes = new HashSet<>();
		Map<Integer, Integer> freq = new TreeMap<>();

		for (int j = 0; j < votes[0].length; j++) {
			for (int i = 0; i < votes.length; i++) {
				int vote = votes[i][j];
				if (deletes.contains(vote))
					continue;
				if (!freq.containsKey(vote))
					freq.put(vote, 1);
				else
					freq.put(vote, freq.get(vote) + 1);
			}

			if (freq.size() > 1) {
				int min = Integer.MAX_VALUE;
				int vote = -1;
				for (Integer key : freq.keySet()) {
					int f = freq.get(key);
					if (min > f) {
						min = f;
						vote = key;
					}
				}
				deletes.add(vote);
				freq.remove(vote);
			}
		}

		for (Integer fruit : freq.keySet()) {
			System.out.println(fruit);
		}
	}
}
