package leetcode.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReSortArray {

	// time complexity = O(n) + O(klogk) and since k is very small this second argument is negligible. Thus the order is ~O(n) 
	public static void main(String[] args) {
		int[] nums = {1, 3, 5, 6, 4, 2, 12};
		List<Integer> sorted = new ArrayList<>();
		List<Integer> unsorted = new ArrayList<>();
		sorted.add(nums[0]);
		int i = 1;
		for(; i < nums.length; i++) {
			if(nums[i] > sorted.get(i - 1)) {
				sorted.add(nums[i]);
			} else {
				break;
			}
		}
		
		for(int  k = i; k < nums.length; k++) {
			unsorted.add(nums[k]);
		}
		
		// time complexity = O(klogk) where k = size of unsorted array
		Collections.sort(unsorted);
		int[] a = new int[sorted.size()];
		int[] b = new int[unsorted.size()];
		int m = 0, n = 0;
		for(int s : sorted) {
			a[m++] = s;
		}
		for(int s : unsorted) {
			b[n++] = s;
		}
		
		// time complexity = O(n) 
		a = merge(a,b);
		
		for(int s : a) {
			System.out.print(s + ", ");
		}
	}

	private static int[] merge(int[] a, int[] b) {
		int n = 0, m = 0, k = 0;
		
		int[] result = new int[a.length + b.length];
		
		while(n < a.length && m < b.length) {
			if(a[n] <= b[m]) {
				result[k++] = a[n++];
			} else {
				result[k++] = b[m++];
			}
		}
		
		while(n < a.length) {
			result[k++] = a[n++];
		}
		while(m < b.length) {
			result[k++] = b[m++];
		}
		
		return result;
		
	}
}
