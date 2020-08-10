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
		Map<Integer, Pair<Integer>> sumMap = new HashMap<Integer, Pair<Integer>>();
		Set<List<Integer>> results = new HashSet<>();

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				sumMap.put(nums[i] + nums[j], new Pair<Integer>(nums[i], nums[j]));
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

class Pair<T> {
	private T a;
	private T b;

	public Pair(T a, T b) {
		super();
		this.a = a;
		this.b = b;
	}

	public T getA() {
		return a;
	}

	public void setA(T a) {
		this.a = a;
	}

	public T getB() {
		return b;
	}

	public void setB(T b) {
		this.b = b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
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
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		return true;
	}

}
