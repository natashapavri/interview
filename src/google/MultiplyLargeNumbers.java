package google;

public class MultiplyLargeNumbers {

	public static void main(String[] args) {
		String a = "120", b = "110";
		String zeros = findZeros(a, b);
		a = truncateAllZeros(a);
		b = truncateAllZeros(b);
		String product = multiply(a, b);
		product = product.concat(zeros);
		System.out.println(product);
	}

	private static String findZeros(String a, String b) {
		String zeros = "";
		while(a.endsWith("0")) {
			zeros = zeros.concat("0");
			a = a.substring(0, a.length() - 1);
		}
		while(b.endsWith("0")) {
			zeros = zeros.concat("0");
			b = b.substring(0, b.length() - 1);
		}
		return zeros;
	}

	private static String truncateAllZeros(String str) {
		while(str.startsWith("0")) {
			str = str.substring(1);
		}
		while(str.endsWith("0")) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	private static String multiply(String a, String b) {
		long sum = 0;
		int k = 0;
		for(int i = b.length() - 1; i>=0; i--) {
			int bDigit = b.charAt(i) - '0';
			int carry = 0;
			int rowSum = 0;
			int r = 0;
			for(int j = a.length() - 1; j>=0; j--) {
				int aDigit = a.charAt(j) - '0';
				int product = (aDigit * bDigit) + carry;
				carry = (product >= 10) ? product / 10 : 0;
				product = product % 10;
				// to create a number given digits in reverse order (2 and then 1)
				rowSum = rowSum + (product * ((int)Math.pow(10, r++)));
			}
			rowSum = (rowSum * ((int)Math.pow(10, k++)));
			sum+=rowSum;
		}
		
		return String.valueOf(sum);
	}
}
