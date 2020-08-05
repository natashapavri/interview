package google;

public class ModuloPowerArithmetic {

	public static void main(String[] args) {
		int b = 2, e = 3, m = 3;

		long result = findExpoMod(b, e, m);

		System.out.println(result);
	}

	private static long findExpoMod(int b, int e, int m) {
		if (m == 1)
			return 0;

		long result = 1;
		b = b % m;
		while (e > 0) {
			if (e % 2 == 1) {
				result = (result * b) % m;
			}
			e = e >> 1;
			b = (b * b) % m;
		}
		return result;
	}
}
