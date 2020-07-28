package arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RosesBloom {

	public static void main(String[] args) {
		int[] roses = { 1, 2, 4, 9, 3, 4, 1 };
		int k = 2, n = 2;
		int total_roses = k * n;

		int days = 0;
		int[] blooms = new int[7];
		Map<Integer, List<Integer>> dayToRoseIndex = new HashMap<>();

		for (int i = 0; i < roses.length; i++) {
			dayToRoseIndex.putIfAbsent(roses[i], new ArrayList<>());
			dayToRoseIndex.get(roses[i]).add(i);
		}

		for (Integer day : dayToRoseIndex.keySet()) {
			for (Integer index : dayToRoseIndex.get(day)) {
				blooms[index] = 1;
				if ((index != 0 && blooms[index] == blooms[index - 1])
						|| (index != roses.length - 1 && blooms[index] == blooms[index + 1])) {
					total_roses -= 2;
					days = day;
					if (total_roses == 0)
						break;
				}
			}
			if (total_roses == 0)
				break;
		}
		System.out.println(days);
	}
}
