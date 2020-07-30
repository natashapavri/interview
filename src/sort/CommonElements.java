package sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonElements {

	public static void main(String[] args) {
		int[] a = { 5, 2, 8, 9, 4 };
		int[] b = { 3, 2, 9, 5 };

		Arrays.sort(a);
		Arrays.sort(b);

		int i = 0, j = 0;

		int count = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				count++;
				i++;
				j++;
			} else if (a[i] < b[j])
				i++;
			else if (a[i] > b[j])
				j++;
		}

		System.out.println(count);

		// method 2

		Set<Integer> nums = new HashSet<>();
		for (int p = 0; p < a.length; p++) {
			nums.add(a[p]);
		}

		int count1 = 0;
		for (int k = 0; k < b.length; k++) {
			if (nums.contains(b[k]))
				count1++;
		}

		System.out.println(count1);
	}
}
