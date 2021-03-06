package arrays;

import java.util.HashMap;

public class SubArrayForSumPrefix {

	public int[] findSubArray(int[] arrA, int Sum) {

		//map of prefix sum & index
		HashMap<Integer, Integer> sums = new HashMap<>();
		int prefixSum = 0;
		int start = 0;
		int end = -1;
		for (int i = 0; i < arrA.length; i++) {
			prefixSum += arrA[i];
			if (prefixSum - Sum == 0) {
				start = 0;
				end = i;
				break;
			}

			if (sums.containsKey(prefixSum - Sum)) {
				start = sums.get(prefixSum - Sum) + 1;
				end = i;
				break;
			}

			sums.put(prefixSum, i);
		}

		int[] result = new int[end - start + 1];
		int i = 0;
		for (int j = start; j <= end; j++) {
			result[i++] = arrA[j];
		}
		return result;
	}

	public static void main(String[] args) throws java.lang.Exception {
		// int[] arrA = { 25, -25, 30, 10, 19, 15, 10, 23 };
		int[] arrA = { 1, 2, -5, 1, 2, -1 };
		int Sum = 0;
		SubArrayForSumPrefix i = new SubArrayForSumPrefix();
		int[] result = i.findSubArray(arrA, Sum);
		for (int j = 0; j < result.length; j++) {
			System.out.print(result[j] + ", ");
		}
	}
}