import java.util.HashMap;
import java.util.Map;

public class FruitBasket {

	public static void main(String[] args) {
		int[] trees = { 0, 1, 1, 2, 1 };
		int k = 2;
		int left = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max_fruits = 0;

		for (int i = 0; i < trees.length; i++) {
			if (map.size() <= k) {
				map.put(trees[i], i);
			}
			if (map.size() > 2) {
				int min_index = Integer.MAX_VALUE;
				for (int val : map.values()) {
					min_index = Math.min(min_index, val);
				}
				map.remove(trees[min_index]);
				left = min_index + 1;
			}
			max_fruits = Math.max(max_fruits, i - left + 1);
		}

		System.out.println(max_fruits);
	}
}
