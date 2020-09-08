package google;

public class DominoMinRotations {

	public static void main(String[] args) {
		int[] A = { 1,1,1,1,1,1,1,1 };
		int[] B = { 1,1,1,1,1,1,1,1 };

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

		int minRotations = Integer.MIN_VALUE;
		for (int i = 0; i < 7; i++) {
			if (upper[i] + lower[i] - duplicates[i] == A.length) {
				minRotations = A.length - Math.max(upper[i], lower[i]);
			}
		}
		if (minRotations == Integer.MIN_VALUE) {
			System.out.println(-1);
		}
		System.out.println(minRotations);
	}
}
