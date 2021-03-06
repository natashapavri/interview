package string;

public class ExcelColumnFromIndex {

	public static void main(String[] args) {
		int n = 701;
		System.out.println(convertToTitle(n));
		String str = "AB";
		System.out.println(convertToNumber(str));
	}

	private static int convertToNumber(String str) {
		
		int result = 0;
		for(int i = 0 ;i<str.length(); i++) {
			result = result * 26;
			result = result + (str.charAt(i) - 'A') + 1;
		}
		
		return result;
	}

	private static String convertToTitle(int n) {
		if (n <= 0)
			return null;
		String temp = "";
		while (n > 0) {
			char c = getCharacterForInt((n - 1) % 26);
			temp = c + temp;
			n = (n - 1) / 26;
		}

		return temp;
	}

	private static char getCharacterForInt(int i) {
		return (char) (i + 'A');
	}
}
