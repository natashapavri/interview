package google;

import java.util.ArrayList;
import java.util.List;

public class IntersectionUnionArrays {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 3, 4, 5, 6 };
		int[] b = { 3, 3, 5 };

		List<Integer> result = getIntersection(a, b);
		for (Integer r : result) {
			System.out.print(r + ", ");
		}
		
		System.out.println();
		
		result = getUnion(a, b);
		for (Integer r : result) {
			System.out.print(r + ", ");
		}
	}

	// uncomment code if you wish to take union without dupes
	private static List<Integer> getUnion(int[] a, int[] b) {
		List<Integer> result = new ArrayList<>();
		int i = 0, j = 0;
		while(i < a.length && j < b.length) {
			/*if(i != 0 && a[i] == a[i - 1]) {
				i++;
			}
			if(j != 0 && b[j] == b[j - 1]) {
				j++;
			}*/
			if(a[i] == b[j]) {
				result.add(a[i]);
				i++;
				j++;
			} else if(a[i] < b[j]) {
				result.add(a[i]);
				i++;
			} else {
				result.add(b[j]);
				j++;
			}
		}
		
		if(i < a.length) {
			result.add(a[i++]);
		}
		if(j < b.length) {
			result.add(b[j++]);
		}
		
		return result;
	}

	// uncomment code if you wish to take intersection without dupes
	private static List<Integer> getIntersection(int[] a, int[] b) {
		List<Integer> result = new ArrayList<Integer>();

		int i = 0, j = 0;

		while (i < a.length && j < b.length) {
			/*if (i != 0 && a[i] == a[i - 1]) {
				i++;
			}
			if (j != 0 && b[j] == b[j - 1]) {
				j++;
			} else*/ if (a[i] == b[j]) {
				result.add(a[i]);
				i++;
				j++;
			} else if (a[i] < b[j]) {
				i++;
			} else {
				j++;
			}
		}
		return result;
	}
	
	
}
