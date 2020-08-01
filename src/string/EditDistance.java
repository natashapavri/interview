package string;

public class EditDistance {

	public static void main(String[] args) {
		String str1 = "sunday";
		String str2 = "saturday";

		int distance = getEditDistance(str1, str2, str1.length(), str2.length());

		System.out.println(distance);
	}

	private static int getEditDistance(String str1, String str2, int m, int n) {
		if (m == 0)
			return n;
		if (n == 0)
			return m;

		if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			// if last char is equal then check remaining strings
			return getEditDistance(str1, str2, m - 1, n - 1);
		} else {
			// return 1 + min(insert - m, n-1, remove - m-1, n, replace - n-1,m-1
			return 1 + min(getEditDistance(str1, str2, m, n - 1), getEditDistance(str1, str2, m - 1, n - 1),
					getEditDistance(str1, str2, m - 1, n));
		}
	}

	private static int min(int x, int y, int z) {
		if (x <= y && x <= z)
			return x;
		if (y <= z && y <= x)
			return y;
		else
			return z;
	}

}
