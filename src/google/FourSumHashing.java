package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourSumHashing {

	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		Set<List<Integer>> results = findSums(nums, target);

		for (List<Integer> sum : results) {
			for (Integer i : sum) {
				System.out.print(i + ", ");
			}
			System.out.println();
		}
	}

	private static Set<List<Integer>> findSums(int[] nums, int target) {
		Map<Integer, Pair> sumMap = new HashMap<Integer, Pair>();
		Set<List<Integer>> results = new HashSet<>();

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				sumMap.put(nums[i] + nums[j], new Pair(nums[i], nums[j]));
			}
		}

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				int diff = target - sum;
				if (sumMap.containsKey(diff)) {
					if (sumMap.get(diff).getA() != nums[i] && sumMap.get(diff).getB() != nums[j]
							&& sumMap.get(diff).getA() != nums[j] && sumMap.get(diff).getB() != nums[i]) {
						List<Integer> s = new ArrayList<Integer>();
						s.add(nums[i]);
						s.add(nums[j]);
						s.add(sumMap.get(diff).getA());
						s.add(sumMap.get(diff).getB());
						Collections.sort(s);
						results.add(s);
					}

				}
			}
		}

		return results;
	}
}

class Pair {
	private int a;
	private int b;

	public Pair(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
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
		Pair other = (Pair) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		return true;
	}

}
