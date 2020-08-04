package google;

public class DominoMinRotations {

	public static void main(String[] args) {
		int[] A = { 2, 1, 2, 4, 2, 2 };
		int[] B = { 5, 2, 6, 2, 3, 2 };

		int[] upper = new int[7];
		int[] lower = new int[7];
		int[] duplicates = new int[7];

		for (int i = 0; i < A.length; i++) {
			if (A[i] == B[i]) {
				duplicates[A[i]] += 1;
			}

			upper[A[i]] += 1;
			lower[B[i]] += 1;
		}

		int minRotations = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (upper[i] + lower[i] - duplicates[i] == A.length) {
				minRotations = A.length - Math.max(upper[i], lower[i]);
			}
		}
		if (minRotations == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		System.out.println(minRotations);
	}
}
