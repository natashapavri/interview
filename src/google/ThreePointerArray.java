package google;

public class ThreePointerArray {

	public static void main(String[] args) {
		int[] a = { 1, 4, 10 };
		int[] b = { 2, 15, 20 };
		int[] c = { 10, 12 };

		int[] result = new int[3];
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				for (int k = 0; k < c.length; k++) {
					int max = Math.max(Math.max(Math.abs(a[i] - b[j]),Math.abs(b[j] - c[k])), Math.abs(c[k] - a[i]));
					if(max < min) {
						min = max;
						result[0] = i;
						result[1] = j;
						result[2] = k;
					}
				}
			}
		}
		
		System.out.println(result[0] + ", " + result[1] + ", " + result[2]);
		System.out.println(min);
	}

}
