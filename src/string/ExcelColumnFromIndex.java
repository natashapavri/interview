package string;

public class ExcelColumnFromIndex {

	public static void main(String[] args) {
		int n = 52;
		System.out.println(convertToTitle(n));
	}

	private static String convertToTitle(int n) {
		if (n <= 0)
			return null;
		String temp = "";
		while (n > 0) {
			char c = getCharacterForInt((n - 1) % 26);
			temp = temp + c;
			n = (n - 1) / 26;
		}

		String output = "";
		for (int i = temp.length() - 1; i >= 0; i--) {
			output += temp.charAt(i);
		}

		return output;
	}

	private static char getCharacterForInt(int i) {
		return (char) (i + 'A');
	}
}
