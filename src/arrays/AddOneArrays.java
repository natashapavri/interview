package arrays;

public class AddOneArrays {

	public static void main(String[] args) {
		int[] arr = {9,9,9};
		int add = 1;
		int[] sum = new int[arr.length + 1];
		addNumbers(arr, add, 0, sum);
		for(int i : sum) {
			System.out.print(i + "->");
		}
	}

	private static void addNumbers(int[] arr, int add, int carry, int[] sum) {
		int k = sum.length - 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			int result = arr[i] + add + carry;
			carry = (result >= 10) ? result / 10 : 0;
			sum[k--] = result % 10;
			add = 0;
		}
		if(carry != 0) {
			sum[k] = carry;
		}
	}

}
