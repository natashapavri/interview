package leetcode.google;

public class MinimumSwapsFor2Arrays {

	public static void main(String[] args) {
		int[] A = { 1, 4, 4, 9 };
		int[] B = { 2, 3, 5, 10 };

		int lastSwap = 1;
		int lastNoSwap = 0;

		for (int i = 1; i < A.length; i++) {
			int swap = Integer.MAX_VALUE;
			int noSwap = Integer.MAX_VALUE;

			/**
			 * Now, if a1 < a2 and b1 < b2, then it is allowed to have both of
			 * these columns natural (unswapped), or both of these columns
			 * swapped. This possibility leads to n2 = min(n2, n1) and s2 =
			 * min(s2, s1 + 1).
			 * 
			 * Another, (not exclusive) possibility is that a1 < b2 and b1 < a2.
			 * This means that it is allowed to have exactly one of these
			 * columns swapped. This possibility leads to n2 = min(n2, s1) or s2
			 * = min(s2, n1 + 1)
			 */
			if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
				noSwap = Math.min(noSwap, lastNoSwap);
			}
			if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
				swap = Math.min(swap, lastSwap + 1);
			}
			if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
				noSwap = Math.min(noSwap, lastSwap);
			}
			if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
				swap = Math.min(swap, lastNoSwap + 1);
			}

			lastNoSwap = noSwap;
			lastSwap = swap;
		}

		System.out.println(Math.min(lastSwap, lastNoSwap));
	}
}
