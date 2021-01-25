package google;

public class MedianSortedArrayNotSameSize {

	public static void main(String[] args) {
		int[] A = { 1, 4, 5 };
		int[] B = { 2, 3 };

		if (A.length > B.length) {
			int[] temp = A;
			A = B;
			B = temp;
		}

		int half = (A.length + B.length) / 2;

		int l = 0, r = A.length - 1;
		int median = -1;
		while (l <= r) {
			int i = (l + r) / 2;
			int j = half - i - 2;

			int Aleft = Integer.MIN_VALUE;
			int Aright = Integer.MAX_VALUE;
			int Bleft = Integer.MIN_VALUE;
			int Bright = Integer.MAX_VALUE;

			if (i >= 0) {
				Aleft = A[i];
			}
			if (i + 1 < A.length) {
				Aright = A[i + 1];
			}
			if (j >= 0) {
				Bleft = B[j];
			}
			if (j + 1 < B.length) {
				Bright = B[j + 1];
			}

			if (Aright >= Bleft && Bright >= Aleft) {
				// return median
				if ((A.length + B.length) % 2 != 0) {
					median = Math.min(Aright, Bright);
					break;
				} else {
					median = (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2;
					break;
				}
			} else if (Aleft > Bright) {
				r = i - 1;
			} else {
				l = i + 1;
			}
		}
		
		System.out.println(median);
	}

}
