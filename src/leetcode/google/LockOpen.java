package leetcode.google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LockOpen {

	/**
	 * Total permutations of locks = 10 * 10 * 10 * 10 We create 2 new strings
	 * for every node. Each string construction is O(N). We do this for each
	 * digit of the node (i.e. 4 times). D is size of dead ends.
	 * 
	 * Time complexity = O(10^N) * O(4N) + D 
	 * Space complexity = O(D) + O(10^N)
	 */
	public static void main(String[] args) {
		String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
		String target = "0202";

		Set<String> deads = new HashSet<>();
		for (String s : deadends) {
			deads.add(s);
		}

		int count = findPath(deads, target);
		System.out.println(count);
	}

	private static int findPath(Set<String> deads, String target) {
		int count = 0;
		Queue<String> queue = new LinkedList<>();
		queue.add("0000");

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				String str = queue.poll();
				if (str.equals(target)) {
					return count;
				}
				if (deads.contains(str))
					continue;
				deads.add(str);

				for (int i = 0; i < 4; i++) {
					char c = (str.charAt(i) == '9') ? '0' : (char) (str.charAt(i) + 1);
					String nextAdd = str.substring(0, i) + c + str.substring(i + 1);
					c = (str.charAt(i) == '0') ? '9' : (char) (str.charAt(i) - 1);
					String nextMinus = str.substring(0, i) + c + str.substring(i + 1);
					queue.add(nextAdd);
					queue.add(nextMinus);
				}
			}
			count++;
		}

		return -1;
	}
}
