package leetcode.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SequenceReconstruction {

	/**
	 * For org to be uniquely reconstructible from seqs we need to satisfy 2
	 * conditions:
	 * 
	 * 1. Every sequence in seqs should be a subsequence in org. This part is
	 * obvious. 2. Every 2 consecutive elements in org should be consecutive
	 * elements in some sequence from seqs. Why is that? Well, suppose condition
	 * 1 is satisfied. Then for 2 any consecutive elements x and y in org we
	 * have 2 options. We have both x and y in some sequence from seqs. Then (as
	 * condition 1 is satisfied) they must be consecutive elements in this
	 * sequence. There is no sequence in seqs that contains both x and y. In
	 * this case we cannot uniquely reconstruct org from seqs as sequence with x
	 * and y switched would also be a valid original sequence for seqs.
	 * 
	 */
	public static void main(String[] args) {
		int[][] seqs = { { 1, 2 }, { 1, 3 } };
		int[] orgs = { 1, 2, 3 };
		boolean result = sequenceReconstruction(seqs, orgs);
		System.out.println(result);
	}

	public static boolean sequenceReconstruction(int[][] seqs, int[] orgs) {
		// note indices of all elements in result
		Map<Integer, Integer> order = new HashMap<>();
		for (int i = 0; i < orgs.length; i++)
			order.put(orgs[i], i);

		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] seq : seqs) {
			if (seq.length == 1) {
				map.putIfAbsent(seq[0], new HashSet<>());
				continue;
			}
			for (int i = 0; i < seq.length - 1; i++) {
				Integer prev = seq[i];
				Integer next = seq[i + 1];
				map.putIfAbsent(prev, new HashSet<>());
				map.putIfAbsent(next, new HashSet<>());
				if (!order.containsKey(prev) || !order.containsKey(next) || order.get(prev) >= order.get(next))
					return false;
				map.get(prev).add(next);
			}
		}
		if (map.keySet().size() != orgs.length || !map.containsKey(orgs[0]))
			return false;
		for (int i = 0; i < orgs.length - 1; i++) {
			if (!map.get(orgs[i]).contains(orgs[i + 1]))
				return false;
		}
		return true;

	}
}
