package arrays;

public class MergeSortedArray {

	int[] mergeSorted(int[] a, int[] b, int n, int m) {
		int[] arr = new int[n + m];
		int i = n - 1;
		int j = m - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			System.out.println("comparing" + a[i] + ":" + b[j]);
			if (a[i] > b[j]) {
				arr[k--] = a[i--];
			} else {
				arr[k--] = b[j--];
			}
		}
		while (j >= 0) {
			arr[k--] = b[j--];
		}
		while (i >= 0) {
			arr[k--] = a[i--];
		}

		return arr;
	}

	public static void main(String[] args) {
		MergeSortedArray obj = new MergeSortedArray();
		int[] a = { 1, 3, 5, 7 };
		int[] b = { 2, 4, 6, 9 };
		int[] result = obj.mergeSorted(a, b, a.length, b.length);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
