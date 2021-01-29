package arrays;
import java.util.HashSet;
import java.util.Set;

public class FruitBasket {

	public static void main(String[] args) {
		int[] trees = { 0, 1, 1, 2, 1 };
		Set<Integer> types = new HashSet<>();

		int max_fruits = Integer.MIN_VALUE;
		for (int i = 0; i < trees.length; i++) {
			int fruits = 1;
			types.clear();
			types.add(trees[i]);
			max_fruits = Math.max(max_fruits, fruits);
			for (int j = i + 1; j < trees.length; j++) {
				if (types.contains(trees[j]) || types.size() < 2) {
					if (trees[i] != trees[j]) {
						types.add(trees[j]);
					}
					fruits++;
					max_fruits = Math.max(max_fruits, fruits);
				} else {
					break;
				}
			}
		}
		System.out.println(max_fruits);
	}
}
