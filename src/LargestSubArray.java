
public class LargestSubArray {

	public static void main(String[] args) {
		int k = 4;
		int[] arr = { 1,4,3,2,5 };

		int[] result = new int[4];

		int start = 0;
		for (int i = 0; i < arr.length - k + 1; i++) {
			if(arr[start] < arr[i]) {
				start = i;
			}
		}
		
		int p = 0;
		for(int i=start;i<(start+k);i++) {
			result[p++] = arr[i];
		}

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
